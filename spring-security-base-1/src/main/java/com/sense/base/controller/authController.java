package com.sense.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class authController {

    @GetMapping("hello")
    public String hello(String username) {
        return "hello ,"+ username;
    }

    @GetMapping("hello2")
    public String hello2(String username) {
        return "hello2,"+ username;
    }

    @GetMapping("hello3")
    public String hello3(String username) {
        return "hello3,"+ username;
    }

}
