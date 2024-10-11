package com.xt.business.sys.controller;

import com.xt.business.sys.controller.request.RoleRequest;
import com.xt.business.sys.controller.response.RoleResponse;
import com.xt.business.sys.service.IRoleService;
import com.xt.common.PageRequest;
import com.xt.common.ResponseResult;
import com.xt.common.PageResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* 角色表 控制层
* @author chai
* @since 2024-10-02
*/
@Api(tags = "角色表")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private IRoleService IRoleService;

    @ApiOperation(value = "查询列表")
    @PostMapping("/getRoleList")
    public ResponseResult<List<RoleResponse>> getRoleList(@RequestBody RoleRequest request) {
        return ResponseResult.success(IRoleService.getRoleList(request));
    }

    @ApiOperation(value = "分页查询列表")
    @PostMapping("/getRolePage")
    public ResponseResult<PageResponse<RoleResponse>> getRolePage(@RequestBody PageRequest<RoleRequest> request) {
        return ResponseResult.success(IRoleService.getRolePage(request));
    }

    @ApiOperation(value = "查询详情")
    @PostMapping("/getRoleOne")
    public ResponseResult<RoleResponse> getRoleOne(@RequestBody RoleRequest request) {
        return ResponseResult.success(IRoleService.getRoleOne(request));
    }

    @ApiOperation(value = "新增")
    @PostMapping("/insertRole")
    public ResponseResult<Integer> insertRole(@RequestBody RoleRequest request) {
        return ResponseResult.success(IRoleService.insertRole(request));
    }

    @ApiOperation(value = "批量新增")
    @PostMapping("/insertBatchRole")
    public ResponseResult<Integer> insertBatchRole(@RequestBody List<RoleRequest> request) {
        return ResponseResult.success(IRoleService.insertBatchRole(request));
    }

    @ApiOperation(value = "修改")
    @PutMapping("/updateRole")
    public ResponseResult<Integer> updateRole(@RequestBody RoleRequest request) {
        return ResponseResult.success(IRoleService.updateRole(request));
    }

    @ApiOperation(value = "通过Ids批量修改")
    @PostMapping("/updateBatchRoleIds")
    public ResponseResult<Integer> updateBatchRoleIds(@RequestBody RoleRequest request) {
        return ResponseResult.success(IRoleService.updateBatchRoleIds(request));
    }

    @ApiOperation(value = "批量修改")
    @PostMapping("/updateBatchRole")
    public ResponseResult<Integer> updateBatchRole(@RequestBody List<RoleRequest> request) {
        return ResponseResult.success(IRoleService.updateBatchRole(request));
    }

    @ApiOperation(value = "删除")
    @PostMapping("/deleteRole")
    public ResponseResult<Integer> deleteRole(@RequestBody RoleRequest request) {
        return ResponseResult.success(IRoleService.deleteRole(request));
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/deleteBatchRole")
    public ResponseResult<Integer> deleteBatchRole(@RequestBody RoleRequest request) {
        return ResponseResult.success(IRoleService.deleteBatchRole(request));
    }

}