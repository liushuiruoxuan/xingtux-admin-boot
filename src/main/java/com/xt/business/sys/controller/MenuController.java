package com.xt.business.sys.controller;


import com.xt.business.sys.controller.request.MenuRequest;
import com.xt.business.sys.controller.response.MenuResponse;
import com.xt.business.sys.service.IMenuService;
import com.xt.common.PageRequest;
import com.xt.common.ResponseResult;
import com.xt.common.PageResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* 菜单表 控制层
* @author chai
* @since 2024-10-02
*/
@Api(tags = "菜单表")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private IMenuService IMenuService;

    @ApiOperation(value = "查询列表")
    @PostMapping("/getMenuList")
    public ResponseResult<List<MenuResponse>> getMenuList(@RequestBody MenuRequest request) {
        return ResponseResult.success(IMenuService.getMenuList(request));
    }
    @ApiOperation(value = "查询列表")
    @GetMapping("/selfMenu")
    public ResponseResult<List<MenuResponse>> searchSelfMenu() {
        return ResponseResult.success(IMenuService.searchSelfMenu());
    }
    @ApiOperation(value = "分页查询列表")
    @PostMapping("/getMenuPage")
    public ResponseResult<PageResponse<MenuResponse>> getMenuPage(@RequestBody PageRequest<MenuRequest> request) {
        return ResponseResult.success(IMenuService.getMenuPage(request));
    }

    @ApiOperation(value = "查询详情")
    @PostMapping("/getMenuOne")
    public ResponseResult<MenuResponse> getMenuOne(@RequestBody MenuRequest request) {
        return ResponseResult.success(IMenuService.getMenuOne(request));
    }

    @ApiOperation(value = "新增")
    @PostMapping("/insertMenu")
    public ResponseResult<Integer> insertMenu(@RequestBody MenuRequest request) {
        return ResponseResult.success(IMenuService.insertMenu(request));
    }

    @ApiOperation(value = "批量新增")
    @PostMapping("/insertBatchMenu")
    public ResponseResult<Integer> insertBatchMenu(@RequestBody List<MenuRequest> request) {
        return ResponseResult.success(IMenuService.insertBatchMenu(request));
    }

    @ApiOperation(value = "修改")
    @PostMapping("/updateMenu")
    public ResponseResult<Integer> updateMenu(@RequestBody MenuRequest request) {
        return ResponseResult.success(IMenuService.updateMenu(request));
    }

    @ApiOperation(value = "通过Ids批量修改")
    @PostMapping("/updateBatchMenuIds")
    public ResponseResult<Integer> updateBatchMenuIds(@RequestBody MenuRequest request) {
        return ResponseResult.success(IMenuService.updateBatchMenuIds(request));
    }

    @ApiOperation(value = "批量修改")
    @PostMapping("/updateBatchMenu")
    public ResponseResult<Integer> updateBatchMenu(@RequestBody List<MenuRequest> request) {
        return ResponseResult.success(IMenuService.updateBatchMenu(request));
    }

    @ApiOperation(value = "删除")
    @PostMapping("/deleteMenu")
    public ResponseResult<Integer> deleteMenu(@RequestBody MenuRequest request) {
        return ResponseResult.success(IMenuService.deleteMenu(request));
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/deleteBatchMenu")
    public ResponseResult<Integer> deleteBatchMenu(@RequestBody MenuRequest request) {
        return ResponseResult.success(IMenuService.deleteBatchMenu(request));
    }

}