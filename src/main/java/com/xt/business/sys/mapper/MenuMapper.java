package com.xt.business.sys.mapper;

import com.xt.business.sys.controller.response.MenuResponse;
import com.xt.business.sys.domain.entity.Menu;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
* 菜单表 Mapper 接口
* @author chai
* @since 2024-10-02
*/

@Mapper
public interface MenuMapper  {

    /**
     * 根据条件查询列表
     * @param request
     * @return
     */
    List<Menu> getMenuList(Menu request);

    /**
    * 查询一条数据（查详情）
    * @param request
    * @return
    */
    Menu getMenuOne(Menu request);
    /**
     * 新增
     * @param request
     * @return
     */
    int insertMenu(Menu request);
    /**
     * 批量新增
     * @param request
     * @return
     */
    int insertBatchMenu(@Param("list") List<Menu> request);
    /**
     * 修改
     * @param request
     * @return
     */
    int updateMenu(Menu request);
    /**
     * 通过Ids批量修改
     * @param request
     * @return
     */
    int updateBatchMenuIds(Menu request);
    /**
     * 批量修改
     * @param request
     * @return
     */
    int updateBatchMenu(@Param("list") List<Menu> request);
    /**
     * 逻辑删除
     * @param request
     * @return
     */
    int deleteMenu(Menu request);
    /**
     * 批量逻辑删除
     * @param request
     * @return
     */
    int deleteBatchMenu(Menu request);

    List<MenuResponse> getMenuByRoleIds(List<Long> roleIds);
}

