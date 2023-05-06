package com.bran.admin.controller;

import com.bran.admin.common.bean.ResultBean;
import com.bran.admin.model.AdminUser;
import com.bran.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private AdminUserService adminUserService;

    @Autowired
    public void setAdminUserService(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    //    @Operation(summary = "后台用户登录")
    @PostMapping("login")
    public ResultBean<AdminUser> adminLogin(@RequestBody AdminUser admin) {
        return ResultBean.ok(adminUserService.adminLogin(admin));
    }

}
