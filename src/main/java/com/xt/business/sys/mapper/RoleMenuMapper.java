package com.xt.business.sys.mapper;

import com.xt.business.sys.domain.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
* 角色菜单关联表 Mapper 接口
* @author chai
* @since 2024-10-02
*/

@Mapper
public interface RoleMenuMapper  {

    /**
     * 根据条件查询列表
     * @param request
     * @return
     */
    List<RoleMenu> getRoleMenuList(RoleMenu request);

    /**
    * 查询一条数据（查详情）
    * @param request
    * @return
    */
    RoleMenu getRoleMenuOne(RoleMenu request);
    /**
     * 新增
     * @param request
     * @return
     */
    int insertRoleMenu(RoleMenu request);
    /**
     * 批量新增
     * @param request
     * @return
     */
    int insertBatchRoleMenu(@Param("list") List<RoleMenu> request);
    /**
     * 修改
     * @param request
     * @return
     */
    int updateRoleMenu(RoleMenu request);
    /**
     * 通过Ids批量修改
     * @param request
     * @return
     */
    int updateBatchRoleMenuIds(RoleMenu request);
    /**
     * 批量修改
     * @param request
     * @return
     */
    int updateBatchRoleMenu(@Param("list") List<RoleMenu> request);
    /**
     * 逻辑删除
     * @param request
     * @return
     */
    int deleteRoleMenu(RoleMenu request);
    /**
     * 批量逻辑删除
     * @param request
     * @return
     */
    int deleteBatchRoleMenu(RoleMenu request);
}

