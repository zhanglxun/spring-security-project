package com.sense.provider.auth.controller;

import com.sense.model.auth.Roles;
import com.sense.provider.auth.service.RolesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @date 2023/12/11
 * @version 1.0
 * @description 系统角色管理controller
 */
@Tag(name = "角色管理", description = "系统角色管理")
@RestController
@RequestMapping("/v1/roles")
@Slf4j
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping("/getRolesList")
    public List<Roles> getRolesList(){

        return rolesService.list();
    }




}
