package com.bran.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bran.admin.exception.CheckException;
import com.bran.admin.mapper.AdminUserMapper;
import com.bran.admin.model.AdminUser;
import com.bran.admin.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * desc: 用户模块逻辑层
 * date 2022/5/11 12:06
 *
 * @author cuifuan
 **/
@Service
public class AdminUserService extends ServiceImpl<AdminUserMapper, AdminUser> implements UserDetailsService {

    private AuthenticationManager authenticationManager;
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    public void setJwtTokenUtils(JwtTokenUtils jwtTokenUtils) {
        this.jwtTokenUtils = jwtTokenUtils;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * 根据用户名加载用户
     */
    @Override
    public AdminUser loadUserByUsername(String username) {

        LambdaQueryWrapper<AdminUser> userQuery = Wrappers.<AdminUser>lambdaQuery()
                .eq(AdminUser::getUsername, username);

        return baseMapper.selectOne(userQuery);
    }

    public AdminUser adminLogin(AdminUser admin) {

        AdminUser adminUserx = loadUserByUsername(admin.getUsername());
        Optional.ofNullable(adminUserx)
                .orElseThrow(() -> new CheckException("用户名密码错误!"));
        UsernamePasswordAuthenticationToken upaToken = new UsernamePasswordAuthenticationToken(admin.getUsername(), admin.getPassword());

        authenticationManager.authenticate(upaToken);

        final UserDetails userDetails = this.loadUserByUsername(admin.getUsername());
        final String token = jwtTokenUtils.generateToken(userDetails.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        AdminUser adminUser = this.getCurrentAdminUser();
        adminUser.setToken(token);
        adminUser.setPassword(null);

        return adminUser;
    }

    private AdminUser getCurrentAdminUser() {
        return (AdminUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}




