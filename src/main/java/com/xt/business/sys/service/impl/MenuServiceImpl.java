package com.xt.business.sys.service.impl;

import com.xt.business.sys.domain.entity.Role;
import com.xt.business.sys.domain.entity.UserRole;
import com.xt.business.sys.mapper.RoleMapper;
import com.xt.business.sys.mapper.UserRoleMapper;
import com.xt.common.util.SecurityUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import com.google.common.collect.Lists;
import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.xt.business.sys.controller.request.MenuRequest;
import com.xt.business.sys.controller.response.MenuResponse;
import com.xt.common.PageResponse;
import com.xt.common.PageRequest;
import com.xt.business.sys.service.IMenuService;
import com.xt.business.sys.mapper.MenuMapper;
import com.xt.business.sys.domain.entity.Menu;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* 菜单表 服务实现类
*
* @author chai
* @since 2024-10-02
*/
@Service
@Slf4j
public class MenuServiceImpl implements IMenuService{
    @Resource
    private MenuMapper menuMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Override
    public List<MenuResponse> getMenuList(MenuRequest request) {
      List<Menu> menuList = menuMapper.getMenuList(BeanUtil.copyProperties(request, Menu.class));
      if (CollectionUtils.isEmpty(menuList)) {
        return Lists.newArrayList();
      }
      return BeanUtil.copyToList(menuList, MenuResponse.class);
    }
    @Override
    public PageResponse<MenuResponse> getMenuPage(PageRequest<MenuRequest> request) {
      PageHelper.startPage(request.getPageNum(), request.getPageSize());
      List<Menu> menuList = menuMapper.getMenuList(BeanUtil.copyProperties(request.getParamData(), Menu.class));
      if (CollectionUtils.isEmpty(menuList)) {
         return new PageResponse<>(new PageInfo<>(Lists.newArrayList()));
      }
      return new PageResponse<>(BeanUtil.copyProperties(new PageInfo<>(menuList),PageInfo.class));
    }
    @Override
    public MenuResponse getMenuOne(MenuRequest request) {
      Menu  menu= menuMapper.getMenuOne(BeanUtil.copyProperties(request, Menu.class));
      if (ObjectUtils.isEmpty(menu) ) {
        return new MenuResponse();
      }
      return BeanUtil.copyProperties(menu, MenuResponse.class);
    }


    @Override
    public int insertMenu(MenuRequest request) {
        return menuMapper.insertMenu(BeanUtil.copyProperties(request, Menu.class));
    }

    @Override
    public int insertBatchMenu(List<MenuRequest> request) {
      return menuMapper.insertBatchMenu(BeanUtil.copyToList(request, Menu.class));
    }

    @Override
    public int updateMenu(MenuRequest request) {
      return menuMapper.updateMenu(BeanUtil.copyProperties(request, Menu.class));
    }

    @Override
    public int updateBatchMenuIds(MenuRequest request) {
      return menuMapper.updateBatchMenuIds(BeanUtil.copyProperties(request, Menu.class));
    }

    @Override
    public int updateBatchMenu(List<MenuRequest> request) {
      return menuMapper.updateBatchMenu(BeanUtil.copyToList(request, Menu.class));
    }

    @Override
    public int deleteMenu(MenuRequest request) {
      return menuMapper.deleteMenu(BeanUtil.copyProperties(request, Menu.class));
    }

    @Override
    public int deleteBatchMenu(MenuRequest request) {
      return menuMapper.deleteBatchMenu(BeanUtil.copyProperties(request, Menu.class));
    }

    @Override
    public List<MenuResponse> getMenuByRoleIds(List<Long> roleIds) {
        return menuMapper.getMenuByRoleIds(roleIds);
    }

    @Override
    public List<MenuResponse> searchSelfMenu() {
        Long userId = SecurityUtil.getUserId();
        UserRole userRole = new UserRole();
        log.info("userId:{}",userId);
        userRole.setUserId(userId);
        List<UserRole> userRoleList = userRoleMapper.getUserRoleList(userRole);
        List<Long> roleIds = userRoleList.stream().map(UserRole::getRoleId).toList();
        List<MenuResponse> menuResponseList = getMenuByRoleIds(roleIds);
        List<MenuResponse> router = getRouter(menuResponseList);
        log.info("menuResponseList:{}",menuResponseList);
        return router;
    }


    /**
     * 获取路由
     */
    private List<MenuResponse> getRouter(List<MenuResponse> menuList) {
        List<MenuResponse> routerVOS = new ArrayList<>();
        // 首先获取所有的1级路由
        List<MenuResponse> parentMenu = menuList.stream().filter(item -> item.getParentId() == 0).toList();
        // 转换对象类型
        for (MenuResponse menu : parentMenu) {
            MenuResponse routerVO = new MenuResponse();
            BeanUtil.copyProperties(menu,routerVO);
            routerVOS.add(routerVO);
        }
        // 循环1级路由，获取所有的子菜单
        for (MenuResponse routerVO : routerVOS) {
            // 获取所有的子节点
            List<MenuResponse> childrenList = buildTree(menuList, routerVO.getId());
            routerVO.setChildren(childrenList);
        }
        return routerVOS;
    }

    /**
     * 获取所有子节点，递归获取【如果是2级不需要递归了】
     */
    private List<MenuResponse> buildTree(List<MenuResponse> allMenu,Long parentId) {
        List<MenuResponse> childrenList = new ArrayList<>();
        // 遍历所有的数据
        for (MenuResponse menu : allMenu) {
            // 判断menu的parentId是否与传进来的parentId相同
            if(menu.getParentId().equals(parentId)) {
                MenuResponse MenuResponse = new MenuResponse();
                BeanUtil.copyProperties(menu,MenuResponse);
                childrenList.add(MenuResponse);
            }
        }
        // 递归childrenList可能还有子节点
        for (MenuResponse childrenItem : childrenList) {
            childrenItem.setChildren(buildTree(allMenu,childrenItem.getId()));
        }
        return childrenList;
    }

    /**
     * 获取路由
     */
    private List<MenuResponse> buildChildren(List<MenuResponse> menuList) {
        // 首先获取所有的1级路由
        List<MenuResponse> parentMenu = menuList.stream().filter(item -> item.getParentId() == 0).collect(Collectors.toList());
        // 循环1级路由，获取所有的子菜单
        for (MenuResponse menuResponse : parentMenu) {
            // 获取所有的子节点
            List<MenuResponse> childrenList = buildMenuTree(menuList, menuResponse.getId());
            menuResponse.setChildren(childrenList);
        }
        return parentMenu;
    }

    /**
     * 获取所有子节点，递归获取【如果是2级不需要递归了】
     */
    private List<MenuResponse> buildMenuTree(List<MenuResponse> allMenu,Long parentId) {
        List<MenuResponse> childrenList = new ArrayList<>();
        // 遍历所有的数据
        for (MenuResponse menu : allMenu) {
            // 判断menu的parentId是否与传进来的parentId相同
            if(menu.getParentId().equals(parentId)) {
                childrenList.add(menu);
            }
        }
        // 递归childrenList可能还有子节点
        for (MenuResponse childrenItem : childrenList) {
            childrenItem.setChildren(buildMenuTree(allMenu,childrenItem.getId()));
        }
        return childrenList;
    }

}