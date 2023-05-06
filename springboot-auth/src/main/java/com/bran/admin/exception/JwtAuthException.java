package com.bran.admin.exception;

import cn.hutool.core.util.StrUtil;
import com.bran.admin.common.bean.ResultBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

@Component
@Slf4j
public class JwtAuthException implements Serializable, AccessDeniedHandler, AuthenticationEntryPoint {
    private static final long serialVersionUID = -8970718410437077606L;

    /**
     * AccessDeineHandler 用来解决认证过的用户访问无权限资源时的异常
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex)
            throws IOException {
        restJson(request, response);
    }

    /**
     * AuthenticationEntryPoint 用来解决匿名用户访问无权限资源时的异常
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        restJson(request, response);
    }

    private static void restJson(HttpServletRequest request,
                                 HttpServletResponse resp) throws IOException {
        resp.setContentType(MediaType.APPLICATION_JSON_VALUE);
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        ResultBean<String> resultBean = new ResultBean<>();
        resultBean.setCode(HttpStatus.UNAUTHORIZED.value());
        String msg = StrUtil.format("请求访问：{}，认证失败，无法访问系统资源", request.getRequestURI());
        resultBean.setMsg(msg);
        writer.write(new ObjectMapper().writeValueAsString(resultBean));
        writer.flush();
        writer.close();
    }
}
