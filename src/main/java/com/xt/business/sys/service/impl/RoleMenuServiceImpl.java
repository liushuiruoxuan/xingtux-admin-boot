package com.xt.business.sys.service.impl;

import jakarta.annotation.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import com.google.common.collect.Lists;
import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.xt.business.sys.controller.request.RoleMenuRequest;
import com.xt.business.sys.controller.response.RoleMenuResponse;
import com.xt.common.PageResponse;
import com.xt.common.PageRequest;
import com.xt.business.sys.service.IRoleMenuService;
import com.xt.business.sys.mapper.RoleMenuMapper;
import com.xt.business.sys.domain.entity.RoleMenu;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import java.util.List;
/**
* 角色菜单关联表 服务实现类
*
* @author chai
* @since 2024-10-02
*/
@Service
public class RoleMenuServiceImpl implements IRoleMenuService{
    @Resource
    private RoleMenuMapper roleMenuMapper;
    @Override
    public List<RoleMenuResponse> getRoleMenuList(RoleMenuRequest request) {
      List<RoleMenu> roleMenuList = roleMenuMapper.getRoleMenuList(BeanUtil.copyProperties(request, RoleMenu.class));
      if (CollectionUtils.isEmpty(roleMenuList)) {
        return Lists.newArrayList();
      }
      return BeanUtil.copyToList(roleMenuList, RoleMenuResponse.class);
    }
    @Override
    public PageResponse<RoleMenuResponse> getRoleMenuPage(PageRequest<RoleMenuRequest> request) {
      PageHelper.startPage(request.getPageNum(), request.getPageSize());
      List<RoleMenu> roleMenuList = roleMenuMapper.getRoleMenuList(BeanUtil.copyProperties(request.getParamData(), RoleMenu.class));
      if (CollectionUtils.isEmpty(roleMenuList)) {
         return new PageResponse<>(new PageInfo<>(Lists.newArrayList()));
      }
      return new PageResponse<>(BeanUtil.copyProperties(new PageInfo<>(roleMenuList),PageInfo.class));
    }
    @Override
    public RoleMenuResponse getRoleMenuOne(RoleMenuRequest request) {
      RoleMenu  roleMenu= roleMenuMapper.getRoleMenuOne(BeanUtil.copyProperties(request, RoleMenu.class));
      if (ObjectUtils.isEmpty(roleMenu) ) {
        return new RoleMenuResponse();
      }
      return BeanUtil.copyProperties(roleMenu, RoleMenuResponse.class);
    }


    @Override
    public int insertRoleMenu(RoleMenuRequest request) {
        return roleMenuMapper.insertRoleMenu(BeanUtil.copyProperties(request, RoleMenu.class));
    }

    @Override
    public int insertBatchRoleMenu(List<RoleMenuRequest> request) {
      return roleMenuMapper.insertBatchRoleMenu(BeanUtil.copyToList(request, RoleMenu.class));
    }

    @Override
    public int updateRoleMenu(RoleMenuRequest request) {
      return roleMenuMapper.updateRoleMenu(BeanUtil.copyProperties(request, RoleMenu.class));
    }

    @Override
    public int updateBatchRoleMenuIds(RoleMenuRequest request) {
      return roleMenuMapper.updateBatchRoleMenuIds(BeanUtil.copyProperties(request, RoleMenu.class));
    }

    @Override
    public int updateBatchRoleMenu(List<RoleMenuRequest> request) {
      return roleMenuMapper.updateBatchRoleMenu(BeanUtil.copyToList(request, RoleMenu.class));
    }

    @Override
    public int deleteRoleMenu(RoleMenuRequest request) {
      return roleMenuMapper.deleteRoleMenu(BeanUtil.copyProperties(request, RoleMenu.class));
    }

    @Override
    public int deleteBatchRoleMenu(RoleMenuRequest request) {
      return roleMenuMapper.deleteBatchRoleMenu(BeanUtil.copyProperties(request, RoleMenu.class));
    }
}