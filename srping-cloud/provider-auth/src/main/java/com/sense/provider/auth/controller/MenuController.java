package com.sense.provider.auth.controller;

import com.sense.model.auth.Menu;
import com.sense.provider.auth.service.MenuService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "菜单管理", description = "系统菜单管理")
@RestController
@RequestMapping("/v1/menu")
@Slf4j
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/getMenuById")
    public List<Menu> getMenuById() {
        return menuService.list();
    }

}
