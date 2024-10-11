package com.xt.business.sys.service.impl;

import jakarta.annotation.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import com.google.common.collect.Lists;
import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.xt.business.sys.controller.request.UserRoleRequest;
import com.xt.business.sys.controller.response.UserRoleResponse;
import com.xt.common.PageResponse;
import com.xt.common.PageRequest;
import com.xt.business.sys.service.IUserRoleService;
import com.xt.business.sys.mapper.UserRoleMapper;
import com.xt.business.sys.domain.entity.UserRole;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import java.util.List;
/**
* 用户角色关联表 服务实现类
*
* @author chai
* @since 2024-10-02
*/
@Service
public class UserRoleServiceImpl implements IUserRoleService{
    @Resource
    private UserRoleMapper userRoleMapper;
    @Override
    public List<UserRoleResponse> getUserRoleList(UserRoleRequest request) {
      List<UserRole> userRoleList = userRoleMapper.getUserRoleList(BeanUtil.copyProperties(request, UserRole.class));
      if (CollectionUtils.isEmpty(userRoleList)) {
        return Lists.newArrayList();
      }
      return BeanUtil.copyToList(userRoleList, UserRoleResponse.class);
    }
    @Override
    public PageResponse<UserRoleResponse> getUserRolePage(PageRequest<UserRoleRequest> request) {
      PageHelper.startPage(request.getPageNum(), request.getPageSize());
      List<UserRole> userRoleList = userRoleMapper.getUserRoleList(BeanUtil.copyProperties(request.getParamData(), UserRole.class));
      if (CollectionUtils.isEmpty(userRoleList)) {
         return new PageResponse<>(new PageInfo<>(Lists.newArrayList()));
      }
      return new PageResponse<>(BeanUtil.copyProperties(new PageInfo<>(userRoleList),PageInfo.class));
    }
    @Override
    public UserRoleResponse getUserRoleOne(UserRoleRequest request) {
      UserRole  userRole= userRoleMapper.getUserRoleOne(BeanUtil.copyProperties(request, UserRole.class));
      if (ObjectUtils.isEmpty(userRole) ) {
        return new UserRoleResponse();
      }
      return BeanUtil.copyProperties(userRole, UserRoleResponse.class);
    }


    @Override
    public int insertUserRole(UserRoleRequest request) {
        return userRoleMapper.insertUserRole(BeanUtil.copyProperties(request, UserRole.class));
    }

    @Override
    public int insertBatchUserRole(List<UserRoleRequest> request) {
      return userRoleMapper.insertBatchUserRole(BeanUtil.copyToList(request, UserRole.class));
    }

    @Override
    public int updateUserRole(UserRoleRequest request) {
      return userRoleMapper.updateUserRole(BeanUtil.copyProperties(request, UserRole.class));
    }

    @Override
    public int updateBatchUserRoleIds(UserRoleRequest request) {
      return userRoleMapper.updateBatchUserRoleIds(BeanUtil.copyProperties(request, UserRole.class));
    }

    @Override
    public int updateBatchUserRole(List<UserRoleRequest> request) {
      return userRoleMapper.updateBatchUserRole(BeanUtil.copyToList(request, UserRole.class));
    }

    @Override
    public int deleteUserRole(UserRoleRequest request) {
      return userRoleMapper.deleteUserRole(BeanUtil.copyProperties(request, UserRole.class));
    }

    @Override
    public int deleteBatchUserRole(UserRoleRequest request) {
      return userRoleMapper.deleteBatchUserRole(BeanUtil.copyProperties(request, UserRole.class));
    }
}