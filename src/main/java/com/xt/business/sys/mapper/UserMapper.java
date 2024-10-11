package com.xt.business.sys.mapper;

import com.xt.business.sys.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
* 用户表 Mapper 接口
* @author chai
* @since 2024-10-02
*/

@Mapper
public interface UserMapper  {

    /**
     * 根据条件查询列表
     * @param request
     * @return
     */
    List<User> getUserList(User request);

    /**
    * 查询一条数据（查详情）
    * @param request
    * @return
    */
    User getUserOne(User request);
    /**
     * 新增
     * @param request
     * @return
     */
    int insertUser(User request);
    /**
     * 批量新增
     * @param request
     * @return
     */
    int insertBatchUser(@Param("list") List<User> request);
    /**
     * 修改
     * @param request
     * @return
     */
    int updateUser(User request);
    /**
     * 通过Ids批量修改
     * @param request
     * @return
     */
    int updateBatchUserIds(User request);
    /**
     * 批量修改
     * @param request
     * @return
     */
    int updateBatchUser(@Param("list") List<User> request);
    /**
     * 逻辑删除
     * @param request
     * @return
     */
    int deleteUser(User request);
    /**
     * 批量逻辑删除
     * @param request
     * @return
     */
    int deleteBatchUser(User request);

    User getUserByUserName(int userNameType, String username);
}

