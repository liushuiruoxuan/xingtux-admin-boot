package com.xt.business.sys.service.impl;

import jakarta.annotation.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import com.google.common.collect.Lists;
import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import com.xt.business.sys.controller.request.UserRequest;
import com.xt.business.sys.controller.response.UserResponse;
import com.xt.common.PageResponse;
import com.xt.common.PageRequest;
import com.xt.business.sys.service.IUserService;
import com.xt.business.sys.mapper.UserMapper;
import com.xt.business.sys.domain.entity.User;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import java.util.List;
/**
* 用户表 服务实现类
*
* @author chai
* @since 2024-10-02
*/
@Service
public class UserServiceImpl implements IUserService{
    @Resource
    private UserMapper userMapper;
    @Override
    public List<UserResponse> getUserList(UserRequest request) {
      List<User> userList = userMapper.getUserList(BeanUtil.copyProperties(request, User.class));
      if (CollectionUtils.isEmpty(userList)) {
        return Lists.newArrayList();
      }
      return BeanUtil.copyToList(userList, UserResponse.class);
    }
    @Override
    public PageResponse<UserResponse> getUserPage(PageRequest<UserRequest> request) {
      PageHelper.startPage(request.getPageNum(), request.getPageSize());
      List<User> userList = userMapper.getUserList(BeanUtil.copyProperties(request.getParamData(), User.class));
      if (CollectionUtils.isEmpty(userList)) {
         return new PageResponse<>(new PageInfo<>(Lists.newArrayList()));
      }
      return new PageResponse<>(BeanUtil.copyProperties(new PageInfo<>(userList),PageInfo.class));
    }
    @Override
    public UserResponse getUserOne(UserRequest request) {
      User  user= userMapper.getUserOne(BeanUtil.copyProperties(request, User.class));
      if (ObjectUtils.isEmpty(user) ) {
        return new UserResponse();
      }
      return BeanUtil.copyProperties(user, UserResponse.class);
    }


    @Override
    public int insertUser(UserRequest request) {
        return userMapper.insertUser(BeanUtil.copyProperties(request, User.class));
    }

    @Override
    public int insertBatchUser(List<UserRequest> request) {
      return userMapper.insertBatchUser(BeanUtil.copyToList(request, User.class));
    }

    @Override
    public int updateUser(UserRequest request) {
      return userMapper.updateUser(BeanUtil.copyProperties(request, User.class));
    }

    @Override
    public int updateBatchUserIds(UserRequest request) {
      return userMapper.updateBatchUserIds(BeanUtil.copyProperties(request, User.class));
    }

    @Override
    public int updateBatchUser(List<UserRequest> request) {
      return userMapper.updateBatchUser(BeanUtil.copyToList(request, User.class));
    }

    @Override
    public int deleteUser(UserRequest request) {
      return userMapper.deleteUser(BeanUtil.copyProperties(request, User.class));
    }

    @Override
    public int deleteBatchUser(UserRequest request) {
      return userMapper.deleteBatchUser(BeanUtil.copyProperties(request, User.class));
    }

    @Override
    public User getUserByUserName(int userNameType, String username) {
        return userMapper.getUserByUserName(userNameType, username);
    }
}