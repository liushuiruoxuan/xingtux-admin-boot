package com.xt.business.sys.service;
import com.xt.business.sys.controller.request.RoleRequest;
import com.xt.business.sys.controller.response.RoleResponse;
import com.xt.common.PageResponse;
import com.xt.common.PageRequest;
import java.util.List;


/**
*
* 角色表 服务类
* @author chai
* @since 2024-10-02
*/
public interface IRoleService  {
    /**
    * 根据条件查询列表
    * @param request
    * @return
    */
    List<RoleResponse> getRoleList(RoleRequest request);

    /**
    * 分页查询列表
    * @param request
    * @return
    */
    PageResponse<RoleResponse> getRolePage(PageRequest<RoleRequest> request);
    /**
    * 查询一条数据（查详情）
    * @param request
    * @return
    */
    RoleResponse getRoleOne(RoleRequest request);
    /**
    * 新增
    * @param request
    * @return
    */
    int insertRole(RoleRequest request);
    /**
    * 批量新增
    * @param request
    * @return
    */
    int insertBatchRole(List<RoleRequest> request);
    /**
    * 修改
    * @param request
    * @return
    */
    int updateRole(RoleRequest request);
    /**
    * 通过Ids批量修改
    * @param request
    * @return
    */
    int updateBatchRoleIds(RoleRequest request);
    /**
    * 批量修改
    * @param request
    * @return
    */
    int updateBatchRole(List<RoleRequest> request);
    /**
    * 逻辑删除
    * @param request
    * @return
    */
    int deleteRole(RoleRequest request);
    /**
    * 批量逻辑删除
    * @param request
    * @return
    */
    int deleteBatchRole(RoleRequest request);
}
