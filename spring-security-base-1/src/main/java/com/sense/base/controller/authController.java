package com.sense.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class authController {

    @GetMapping("hello")
    public String hello(String username) {
        return "hello ,"+ username;
    }

}
