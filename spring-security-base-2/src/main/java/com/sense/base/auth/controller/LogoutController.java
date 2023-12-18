package com.sense.base.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {


    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello,"+name;
    }
    @GetMapping("/hello2")
    public String hello2(@RequestParam String name) {
        return "Hello 2,"+name;
    }



    @GetMapping("/logoutSuccess")
    public String logoutSuccess(){
        return "注销成功";
    }


}
