package com.xt.business.sys.mapper;

import com.xt.business.sys.domain.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
* 用户角色关联表 Mapper 接口
* @author chai
* @since 2024-10-02
*/

@Mapper
public interface UserRoleMapper  {

    /**
     * 根据条件查询列表
     * @param request
     * @return
     */
    List<UserRole> getUserRoleList(UserRole request);

    /**
    * 查询一条数据（查详情）
    * @param request
    * @return
    */
    UserRole getUserRoleOne(UserRole request);
    /**
     * 新增
     * @param request
     * @return
     */
    int insertUserRole(UserRole request);
    /**
     * 批量新增
     * @param request
     * @return
     */
    int insertBatchUserRole(@Param("list") List<UserRole> request);
    /**
     * 修改
     * @param request
     * @return
     */
    int updateUserRole(UserRole request);
    /**
     * 通过Ids批量修改
     * @param request
     * @return
     */
    int updateBatchUserRoleIds(UserRole request);
    /**
     * 批量修改
     * @param request
     * @return
     */
    int updateBatchUserRole(@Param("list") List<UserRole> request);
    /**
     * 逻辑删除
     * @param request
     * @return
     */
    int deleteUserRole(UserRole request);
    /**
     * 批量逻辑删除
     * @param request
     * @return
     */
    int deleteBatchUserRole(UserRole request);
}

