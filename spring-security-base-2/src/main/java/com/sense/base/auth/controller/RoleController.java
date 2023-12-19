package com.sense.base.auth.controller;

//import com.sense.base.service.RolesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "角色管理", description = "系统角色管理")
@RestController
@RequestMapping("/v1/roles")
@Slf4j
public class RoleController {


    @GetMapping("/getRolesList")
    public String getRolesList(){

        return "role:admins";
    }

}
