package com.sense.base.auth.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import cn.hutool.json.JSONUtil;

public class LoginFailHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8"); // 返回JSON
        response.setStatus(HttpStatus.UNAUTHORIZED.value());  // 状态码 400
        Map<String, Object> result = new HashMap<>(); // 返回结果
        result.put("code", 401);
        result.put("data", exception.getMessage());
        response.getWriter().write(JSONUtil.toJsonStr(result));
    }
}
