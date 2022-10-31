package com.bran.admin.config;

import com.bran.admin.exception.JwtAuthException;
import com.bran.admin.filter.JwtAuthenticationTokenFilter;
import com.bran.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private static final String[] SKIP_AUTH = new String[]{"/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js",
            "/api/user/login", "/test/**", "/v3/**"};

    private AdminUserService adminUserService;

    @Autowired
    public void setAdminUserService(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    /**
     * 获取AuthenticationManager（认证管理器），登录时认证使用
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // jwt 校验过滤器，从 http 头部 Authorization 字段读取 token 并校验
    @Bean
    public JwtAuthenticationTokenFilter authFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    // 权限不足错误信息处理，包含认证错误与鉴权错误处理
    private JwtAuthException jwtAuthException;

    @Autowired
    public void setJwtAuthException(JwtAuthException jwtAuthException) {
        this.jwtAuthException = jwtAuthException;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // 基于 token，不需要 csrf
                .csrf().disable()
                // 基于 token，不需要 session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 设置 jwtAuthError 处理认证失败、鉴权失败
                .exceptionHandling().authenticationEntryPoint(jwtAuthException).accessDeniedHandler(jwtAuthException).and()
                // 下面开始设置权限
                .authorizeRequests(authorize -> authorize
                        // 请求放开
                        .antMatchers(SKIP_AUTH).permitAll()
                        // 其他地址的访问均需验证权限
                        .anyRequest().authenticated()
                )
                // 添加 JWT 过滤器，JWT 过滤器在用户名密码认证过滤器之前
                .addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class)
                // 认证用户时用户信息加载配置，注入springAuthUserService
                .userDetailsService(adminUserService)
                .build();
    }

    /**
     * 配置跨源访问(CORS)
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}