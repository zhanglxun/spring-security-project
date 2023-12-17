package com.sense.provider.auth.controller;

import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "认证鉴权", description = "系统访问控制")
@RestController
@RequestMapping(value = "/auth")
@Slf4j
public class AuthController {

    @GetMapping("/hello")
    public String hello(String name){
        return "hello,"+name;
    }

}
