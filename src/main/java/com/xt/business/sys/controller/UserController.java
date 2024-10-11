package com.xt.business.sys.controller;

import com.xt.business.sys.controller.request.UserRequest;
import com.xt.business.sys.controller.response.UserResponse;
import com.xt.business.sys.service.IUserService;
import com.xt.common.PageRequest;
import com.xt.common.ResponseResult;
import com.xt.common.PageResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* 用户表 控制层
* @author chai
* @since 2024-10-02
*/
@Api(tags = "用户表")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService IUserService;

    @ApiOperation(value = "查询列表")
    @PostMapping("/getUserList")
    public ResponseResult<List<UserResponse>> getUserList(@RequestBody UserRequest request) {
        return ResponseResult.success(IUserService.getUserList(request));
    }

    @ApiOperation(value = "分页查询列表")
    @PostMapping("/getUserPage")
    public ResponseResult<PageResponse<UserResponse>> getUserPage(@RequestBody PageRequest<UserRequest> request) {
        return ResponseResult.success(IUserService.getUserPage(request));
    }

    @ApiOperation(value = "查询详情")
    @PostMapping("/getUserOne")
    public ResponseResult<UserResponse> getUserOne(@RequestBody UserRequest request) {
        return ResponseResult.success(IUserService.getUserOne(request));
    }

    @ApiOperation(value = "新增")
    @PostMapping("/insertUser")
    public ResponseResult<Integer> insertUser(@RequestBody UserRequest request) {
        return ResponseResult.success(IUserService.insertUser(request));
    }

    @ApiOperation(value = "批量新增")
    @PostMapping("/insertBatchUser")
    public ResponseResult<Integer> insertBatchUser(@RequestBody List<UserRequest> request) {
        return ResponseResult.success(IUserService.insertBatchUser(request));
    }

    @ApiOperation(value = "修改")
    @PostMapping("/updateUser")
    public ResponseResult<Integer> updateUser(@RequestBody UserRequest request) {
        return ResponseResult.success(IUserService.updateUser(request));
    }

    @ApiOperation(value = "通过Ids批量修改")
    @PostMapping("/updateBatchUserIds")
    public ResponseResult<Integer> updateBatchUserIds(@RequestBody UserRequest request) {
        return ResponseResult.success(IUserService.updateBatchUserIds(request));
    }

    @ApiOperation(value = "批量修改")
    @PostMapping("/updateBatchUser")
    public ResponseResult<Integer> updateBatchUser(@RequestBody List<UserRequest> request) {
        return ResponseResult.success(IUserService.updateBatchUser(request));
    }

    @ApiOperation(value = "删除")
    @PostMapping("/deleteUser")
    public ResponseResult<Integer> deleteUser(@RequestBody UserRequest request) {
        return ResponseResult.success(IUserService.deleteUser(request));
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/deleteBatchUser")
    public ResponseResult<Integer> deleteBatchUser(@RequestBody UserRequest request) {
        return ResponseResult.success(IUserService.deleteBatchUser(request));
    }

}