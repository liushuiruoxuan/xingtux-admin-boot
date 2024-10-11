package com.xt.business.sys.mapper;

import com.xt.business.sys.domain.entity.Role;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
* 角色表 Mapper 接口
* @author chai
* @since 2024-10-02
*/

@Mapper
public interface RoleMapper  {

    /**
     * 根据条件查询列表
     * @param request
     * @return
     */
    List<Role> getRoleList(Role request);

    /**
    * 查询一条数据（查详情）
    * @param request
    * @return
    */
    Role getRoleOne(Role request);
    /**
     * 新增
     * @param request
     * @return
     */
    int insertRole(Role request);
    /**
     * 批量新增
     * @param request
     * @return
     */
    int insertBatchRole(@Param("list") List<Role> request);
    /**
     * 修改
     * @param request
     * @return
     */
    int updateRole(Role request);
    /**
     * 通过Ids批量修改
     * @param request
     * @return
     */
    int updateBatchRoleIds(Role request);
    /**
     * 批量修改
     * @param request
     * @return
     */
    int updateBatchRole(@Param("list") List<Role> request);
    /**
     * 逻辑删除
     * @param request
     * @return
     */
    int deleteRole(Role request);
    /**
     * 批量逻辑删除
     * @param request
     * @return
     */
    int deleteBatchRole(Role request);
}

