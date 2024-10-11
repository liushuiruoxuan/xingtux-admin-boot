package com.xt.business.sys.service;
import com.xt.business.sys.controller.request.RoleMenuRequest;
import com.xt.business.sys.controller.response.RoleMenuResponse;
import com.xt.common.PageResponse;
import com.xt.common.PageRequest;
import java.util.List;


/**
*
* 角色菜单关联表 服务类
* @author chai
* @since 2024-10-02
*/
public interface IRoleMenuService  {
    /**
    * 根据条件查询列表
    * @param request
    * @return
    */
    List<RoleMenuResponse> getRoleMenuList(RoleMenuRequest request);

    /**
    * 分页查询列表
    * @param request
    * @return
    */
    PageResponse<RoleMenuResponse> getRoleMenuPage(PageRequest<RoleMenuRequest> request);
    /**
    * 查询一条数据（查详情）
    * @param request
    * @return
    */
    RoleMenuResponse getRoleMenuOne(RoleMenuRequest request);
    /**
    * 新增
    * @param request
    * @return
    */
    int insertRoleMenu(RoleMenuRequest request);
    /**
    * 批量新增
    * @param request
    * @return
    */
    int insertBatchRoleMenu(List<RoleMenuRequest> request);
    /**
    * 修改
    * @param request
    * @return
    */
    int updateRoleMenu(RoleMenuRequest request);
    /**
    * 通过Ids批量修改
    * @param request
    * @return
    */
    int updateBatchRoleMenuIds(RoleMenuRequest request);
    /**
    * 批量修改
    * @param request
    * @return
    */
    int updateBatchRoleMenu(List<RoleMenuRequest> request);
    /**
    * 逻辑删除
    * @param request
    * @return
    */
    int deleteRoleMenu(RoleMenuRequest request);
    /**
    * 批量逻辑删除
    * @param request
    * @return
    */
    int deleteBatchRoleMenu(RoleMenuRequest request);
}
