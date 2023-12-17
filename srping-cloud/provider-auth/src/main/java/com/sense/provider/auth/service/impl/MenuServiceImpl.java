package com.sense.provider.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sense.model.auth.Menu;

import com.sense.provider.auth.mapper.MenuMapper;
import com.sense.provider.auth.service.MenuService;
import org.springframework.stereotype.Service;

/**
* @author
* @description 针对表【s_menu(菜单表)】的数据库操作Service实现
* @createDate 2023-12-07 14:13:13
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService {

}




