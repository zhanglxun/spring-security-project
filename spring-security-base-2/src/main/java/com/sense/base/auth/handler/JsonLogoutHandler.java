package com.sense.base.auth.handler;

import cn.hutool.json.JSONUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 注销处理器
 */
public class JsonLogoutHandler implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

        response.setContentType("application/json;charset=utf-8"); // 返回JSON
        response.setStatus(HttpStatus.OK.value());  // 状态码 200
        Map<String, Object> result = new HashMap<>(); // 返回结果
        result.put("msg", "注销成功");
        result.put("code", 200);
        result.put("data", authentication.getName());
        try {
            response.getWriter().write(JSONUtil.toJsonStr(result));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
