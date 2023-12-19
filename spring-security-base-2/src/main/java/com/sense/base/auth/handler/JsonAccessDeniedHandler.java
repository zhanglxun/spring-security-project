package com.sense.base.auth.handler;

import cn.hutool.json.JSONUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        response.setStatus(HttpStatus.BAD_REQUEST.value());  // 状态码
        Map<String, Object> result = new HashMap<>(); // 返回结果
        result.put("msg", "权限不足，访问被拒绝");
        result.put("code", 400);
        response.getWriter().write(JSONUtil.toJsonStr(result));
    }
}
