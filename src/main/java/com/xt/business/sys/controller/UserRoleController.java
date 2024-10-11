package com.xt.business.sys.controller;

import com.xt.business.sys.controller.request.UserRoleRequest;
import com.xt.business.sys.controller.response.UserRoleResponse;
import com.xt.business.sys.service.IUserRoleService;
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
* 用户角色关联表 控制层
* @author chai
* @since 2024-10-02
*/
@Api(tags = "用户角色关联表")
@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Resource
    private IUserRoleService IUserRoleService;

    @ApiOperation(value = "查询列表")
    @PostMapping("/getUserRoleList")
    public ResponseResult<List<UserRoleResponse>> getUserRoleList(@RequestBody UserRoleRequest request) {
        return ResponseResult.success(IUserRoleService.getUserRoleList(request));
    }

    @ApiOperation(value = "分页查询列表")
    @PostMapping("/getUserRolePage")
    public ResponseResult<PageResponse<UserRoleResponse>> getUserRolePage(@RequestBody PageRequest<UserRoleRequest> request) {
        return ResponseResult.success(IUserRoleService.getUserRolePage(request));
    }

    @ApiOperation(value = "查询详情")
    @PostMapping("/getUserRoleOne")
    public ResponseResult<UserRoleResponse> getUserRoleOne(@RequestBody UserRoleRequest request) {
        return ResponseResult.success(IUserRoleService.getUserRoleOne(request));
    }

    @ApiOperation(value = "新增")
    @PostMapping("/insertUserRole")
    public ResponseResult<Integer> insertUserRole(@RequestBody UserRoleRequest request) {
        return ResponseResult.success(IUserRoleService.insertUserRole(request));
    }

    @ApiOperation(value = "批量新增")
    @PostMapping("/insertBatchUserRole")
    public ResponseResult<Integer> insertBatchUserRole(@RequestBody List<UserRoleRequest> request) {
        return ResponseResult.success(IUserRoleService.insertBatchUserRole(request));
    }

    @ApiOperation(value = "修改")
    @PostMapping("/updateUserRole")
    public ResponseResult<Integer> updateUserRole(@RequestBody UserRoleRequest request) {
        return ResponseResult.success(IUserRoleService.updateUserRole(request));
    }

    @ApiOperation(value = "通过Ids批量修改")
    @PostMapping("/updateBatchUserRoleIds")
    public ResponseResult<Integer> updateBatchUserRoleIds(@RequestBody UserRoleRequest request) {
        return ResponseResult.success(IUserRoleService.updateBatchUserRoleIds(request));
    }

    @ApiOperation(value = "批量修改")
    @PostMapping("/updateBatchUserRole")
    public ResponseResult<Integer> updateBatchUserRole(@RequestBody List<UserRoleRequest> request) {
        return ResponseResult.success(IUserRoleService.updateBatchUserRole(request));
    }

    @ApiOperation(value = "删除")
    @PostMapping("/deleteUserRole")
    public ResponseResult<Integer> deleteUserRole(@RequestBody UserRoleRequest request) {
        return ResponseResult.success(IUserRoleService.deleteUserRole(request));
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/deleteBatchUserRole")
    public ResponseResult<Integer> deleteBatchUserRole(@RequestBody UserRoleRequest request) {
        return ResponseResult.success(IUserRoleService.deleteBatchUserRole(request));
    }

}