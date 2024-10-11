package com.xt.business.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.xt.business.sys.controller.response.MenuResponse;
import com.xt.business.sys.domain.dto.AuthDTO;
import com.xt.business.sys.domain.entity.Role;
import com.xt.business.sys.domain.entity.User;
import com.xt.business.sys.service.IMenuService;
import com.xt.business.sys.service.IUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private IUserService userService;
    @Resource
    private IMenuService menuService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //TODO 验证账号类型
        log.info("username:{}",username);
        int userNameType = 0;
        //根据账号查询用户，同事将角色查出来。
        User user = userService.getUserByUserName(userNameType, username);
        //权限查询
        if (ObjectUtil.isNotNull(user)){
            List<Role> roleList = user.getRoleList();
            List<Long> roleIds = roleList.stream().map(Role::getRoleId).collect(Collectors.toList());
            log.info("roleIds:{}",roleIds);
            List<MenuResponse> menuList = menuService.getMenuByRoleIds(roleIds);
            List<String> perms = menuList.stream().map(MenuResponse::getPerms).collect(Collectors.toList());
            user.setPerms(perms);
        }


        log.info("user:{}",user);
        AuthDTO authDTO = new AuthDTO();
        authDTO.setUser(user);
        authDTO.setId(user.getId());
        return authDTO;
    }
}
