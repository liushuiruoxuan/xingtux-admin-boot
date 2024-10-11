package com.xt.business.sys.service;
import com.xt.business.sys.controller.request.UserRoleRequest;
import com.xt.business.sys.controller.response.UserRoleResponse;
import com.xt.common.PageResponse;
import com.xt.common.PageRequest;
import java.util.List;


/**
*
* 用户角色关联表 服务类
* @author chai
* @since 2024-10-02
*/
public interface IUserRoleService  {
    /**
    * 根据条件查询列表
    * @param request
    * @return
    */
    List<UserRoleResponse> getUserRoleList(UserRoleRequest request);

    /**
    * 分页查询列表
    * @param request
    * @return
    */
    PageResponse<UserRoleResponse> getUserRolePage(PageRequest<UserRoleRequest> request);
    /**
    * 查询一条数据（查详情）
    * @param request
    * @return
    */
    UserRoleResponse getUserRoleOne(UserRoleRequest request);
    /**
    * 新增
    * @param request
    * @return
    */
    int insertUserRole(UserRoleRequest request);
    /**
    * 批量新增
    * @param request
    * @return
    */
    int insertBatchUserRole(List<UserRoleRequest> request);
    /**
    * 修改
    * @param request
    * @return
    */
    int updateUserRole(UserRoleRequest request);
    /**
    * 通过Ids批量修改
    * @param request
    * @return
    */
    int updateBatchUserRoleIds(UserRoleRequest request);
    /**
    * 批量修改
    * @param request
    * @return
    */
    int updateBatchUserRole(List<UserRoleRequest> request);
    /**
    * 逻辑删除
    * @param request
    * @return
    */
    int deleteUserRole(UserRoleRequest request);
    /**
    * 批量逻辑删除
    * @param request
    * @return
    */
    int deleteBatchUserRole(UserRoleRequest request);
}
