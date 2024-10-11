package com.xt.business.sys.service;
import com.xt.business.sys.controller.request.MenuRequest;
import com.xt.business.sys.controller.response.MenuResponse;
import com.xt.common.PageResponse;
import com.xt.common.PageRequest;
import java.util.List;


/**
*
* 菜单表 服务类
* @author chai
* @since 2024-10-02
*/
public interface IMenuService  {
    /**
    * 根据条件查询列表
    * @param request
    * @return
    */
    List<MenuResponse> getMenuList(MenuRequest request);

    /**
    * 分页查询列表
    * @param request
    * @return
    */
    PageResponse<MenuResponse> getMenuPage(PageRequest<MenuRequest> request);
    /**
    * 查询一条数据（查详情）
    * @param request
    * @return
    */
    MenuResponse getMenuOne(MenuRequest request);
    /**
    * 新增
    * @param request
    * @return
    */
    int insertMenu(MenuRequest request);
    /**
    * 批量新增
    * @param request
    * @return
    */
    int insertBatchMenu(List<MenuRequest> request);
    /**
    * 修改
    * @param request
    * @return
    */
    int updateMenu(MenuRequest request);
    /**
    * 通过Ids批量修改
    * @param request
    * @return
    */
    int updateBatchMenuIds(MenuRequest request);
    /**
    * 批量修改
    * @param request
    * @return
    */
    int updateBatchMenu(List<MenuRequest> request);
    /**
    * 逻辑删除
    * @param request
    * @return
    */
    int deleteMenu(MenuRequest request);
    /**
    * 批量逻辑删除
    * @param request
    * @return
    */
    int deleteBatchMenu(MenuRequest request);

    List<MenuResponse> getMenuByRoleIds(List<Long> roleIds);

    List<MenuResponse> searchSelfMenu();
}
