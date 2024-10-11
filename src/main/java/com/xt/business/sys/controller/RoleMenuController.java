package com.xt.business.sys.controller;

import com.xt.business.sys.controller.request.RoleMenuRequest;
import com.xt.business.sys.controller.response.RoleMenuResponse;
import com.xt.business.sys.service.IRoleMenuService;
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
* 角色菜单关联表 控制层
* @author chai
* @since 2024-10-02
*/
@Api(tags = "角色菜单关联表")
@RestController
@RequestMapping("/roleMenu")
public class RoleMenuController {

    @Resource
    private IRoleMenuService IRoleMenuService;

    @ApiOperation(value = "查询列表")
    @PostMapping("/getRoleMenuList")
    public ResponseResult<List<RoleMenuResponse>> getRoleMenuList(@RequestBody RoleMenuRequest request) {
        return ResponseResult.success(IRoleMenuService.getRoleMenuList(request));
    }

    @ApiOperation(value = "分页查询列表")
    @PostMapping("/getRoleMenuPage")
    public ResponseResult<PageResponse<RoleMenuResponse>> getRoleMenuPage(@RequestBody PageRequest<RoleMenuRequest> request) {
        return ResponseResult.success(IRoleMenuService.getRoleMenuPage(request));
    }

    @ApiOperation(value = "查询详情")
    @PostMapping("/getRoleMenuOne")
    public ResponseResult<RoleMenuResponse> getRoleMenuOne(@RequestBody RoleMenuRequest request) {
        return ResponseResult.success(IRoleMenuService.getRoleMenuOne(request));
    }

    @ApiOperation(value = "新增")
    @PostMapping("/insertRoleMenu")
    public ResponseResult<Integer> insertRoleMenu(@RequestBody RoleMenuRequest request) {
        return ResponseResult.success(IRoleMenuService.insertRoleMenu(request));
    }

    @ApiOperation(value = "批量新增")
    @PostMapping("/insertBatchRoleMenu")
    public ResponseResult<Integer> insertBatchRoleMenu(@RequestBody List<RoleMenuRequest> request) {
        return ResponseResult.success(IRoleMenuService.insertBatchRoleMenu(request));
    }

    @ApiOperation(value = "修改")
    @PostMapping("/updateRoleMenu")
    public ResponseResult<Integer> updateRoleMenu(@RequestBody RoleMenuRequest request) {
        return ResponseResult.success(IRoleMenuService.updateRoleMenu(request));
    }

    @ApiOperation(value = "通过Ids批量修改")
    @PostMapping("/updateBatchRoleMenuIds")
    public ResponseResult<Integer> updateBatchRoleMenuIds(@RequestBody RoleMenuRequest request) {
        return ResponseResult.success(IRoleMenuService.updateBatchRoleMenuIds(request));
    }

    @ApiOperation(value = "批量修改")
    @PostMapping("/updateBatchRoleMenu")
    public ResponseResult<Integer> updateBatchRoleMenu(@RequestBody List<RoleMenuRequest> request) {
        return ResponseResult.success(IRoleMenuService.updateBatchRoleMenu(request));
    }

    @ApiOperation(value = "删除")
    @PostMapping("/deleteRoleMenu")
    public ResponseResult<Integer> deleteRoleMenu(@RequestBody RoleMenuRequest request) {
        return ResponseResult.success(IRoleMenuService.deleteRoleMenu(request));
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/deleteBatchRoleMenu")
    public ResponseResult<Integer> deleteBatchRoleMenu(@RequestBody RoleMenuRequest request) {
        return ResponseResult.success(IRoleMenuService.deleteBatchRoleMenu(request));
    }

}