package com.sense.provider.auth.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sense.model.auth.Roles;
import com.sense.provider.auth.mapper.RolesMapper;
import com.sense.provider.auth.service.RolesService;
import org.springframework.stereotype.Service;

/**
* @author Jarvis
* @description 针对表【s_roles(角色表)】的数据库操作Service实现
* @createDate 2023-12-07 12:08:21
*/
@Service
public class RolesServiceImpl extends ServiceImpl<RolesMapper, Roles> implements RolesService {

}




