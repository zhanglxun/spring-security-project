package com.sense.base.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {


    @GetMapping("/login")
    public String login() {
        return "登录成功";
    }

    @GetMapping("getAuth")
    public String getAuth(){

        return "this niming";
    }

}
