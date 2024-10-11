package com.xt.business.sys.service.impl;

import jakarta.annotation.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import com.google.common.collect.Lists;
import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.xt.business.sys.controller.request.RoleRequest;
import com.xt.business.sys.controller.response.RoleResponse;
import com.xt.common.PageResponse;
import com.xt.common.PageRequest;
import com.xt.business.sys.service.IRoleService;
import com.xt.business.sys.mapper.RoleMapper;
import com.xt.business.sys.domain.entity.Role;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import java.util.List;
/**
* 角色表 服务实现类
*
* @author chai
* @since 2024-10-02
*/
@Service
public class RoleServiceImpl implements IRoleService{
    @Resource
    private RoleMapper roleMapper;
    @Override
    public List<RoleResponse> getRoleList(RoleRequest request) {
      List<Role> roleList = roleMapper.getRoleList(BeanUtil.copyProperties(request, Role.class));
      if (CollectionUtils.isEmpty(roleList)) {
        return Lists.newArrayList();
      }
      return BeanUtil.copyToList(roleList, RoleResponse.class);
    }
    @Override
    public PageResponse<RoleResponse> getRolePage(PageRequest<RoleRequest> request) {
      PageHelper.startPage(request.getPageNum(), request.getPageSize());
      List<Role> roleList = roleMapper.getRoleList(BeanUtil.copyProperties(request.getParamData(), Role.class));
      if (CollectionUtils.isEmpty(roleList)) {
         return new PageResponse<>(new PageInfo<>(Lists.newArrayList()));
      }
      return new PageResponse<>(BeanUtil.copyProperties(new PageInfo<>(roleList),PageInfo.class));
    }
    @Override
    public RoleResponse getRoleOne(RoleRequest request) {
      Role  role= roleMapper.getRoleOne(BeanUtil.copyProperties(request, Role.class));
      if (ObjectUtils.isEmpty(role) ) {
        return new RoleResponse();
      }
      return BeanUtil.copyProperties(role, RoleResponse.class);
    }


    @Override
    public int insertRole(RoleRequest request) {
        return roleMapper.insertRole(BeanUtil.copyProperties(request, Role.class));
    }

    @Override
    public int insertBatchRole(List<RoleRequest> request) {
      return roleMapper.insertBatchRole(BeanUtil.copyToList(request, Role.class));
    }

    @Override
    public int updateRole(RoleRequest request) {
      return roleMapper.updateRole(BeanUtil.copyProperties(request, Role.class));
    }

    @Override
    public int updateBatchRoleIds(RoleRequest request) {
      return roleMapper.updateBatchRoleIds(BeanUtil.copyProperties(request, Role.class));
    }

    @Override
    public int updateBatchRole(List<RoleRequest> request) {
      return roleMapper.updateBatchRole(BeanUtil.copyToList(request, Role.class));
    }

    @Override
    public int deleteRole(RoleRequest request) {
      return roleMapper.deleteRole(BeanUtil.copyProperties(request, Role.class));
    }

    @Override
    public int deleteBatchRole(RoleRequest request) {
      return roleMapper.deleteBatchRole(BeanUtil.copyProperties(request, Role.class));
    }
}