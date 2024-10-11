package com.xt.business.sys.service;
import com.xt.business.sys.domain.entity.User;
import com.xt.business.sys.controller.request.UserRequest;
import com.xt.business.sys.controller.response.UserResponse;
import com.xt.common.PageResponse;
import com.xt.common.PageRequest;
import java.util.List;


/**
*
* 用户表 服务类
* @author chai
* @since 2024-10-02
*/
public interface IUserService  {
    /**
    * 根据条件查询列表
    * @param request
    * @return
    */
    List<UserResponse> getUserList(UserRequest request);

    /**
    * 分页查询列表
    * @param request
    * @return
    */
    PageResponse<UserResponse> getUserPage(PageRequest<UserRequest> request);
    /**
    * 查询一条数据（查详情）
    * @param request
    * @return
    */
    UserResponse getUserOne(UserRequest request);
    /**
    * 新增
    * @param request
    * @return
    */
    int insertUser(UserRequest request);
    /**
    * 批量新增
    * @param request
    * @return
    */
    int insertBatchUser(List<UserRequest> request);
    /**
    * 修改
    * @param request
    * @return
    */
    int updateUser(UserRequest request);
    /**
    * 通过Ids批量修改
    * @param request
    * @return
    */
    int updateBatchUserIds(UserRequest request);
    /**
    * 批量修改
    * @param request
    * @return
    */
    int updateBatchUser(List<UserRequest> request);
    /**
    * 逻辑删除
    * @param request
    * @return
    */
    int deleteUser(UserRequest request);
    /**
    * 批量逻辑删除
    * @param request
    * @return
    */
    int deleteBatchUser(UserRequest request);

    /**
     * 根据用户名查询用户
     * @param userNameType
     * @param username
     * @return
     */
    User getUserByUserName(int userNameType, String username);
}
