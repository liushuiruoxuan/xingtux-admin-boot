package ${package.Mapper};

import ${package.Entity}.${entity};
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
* ${table.comment!} Mapper 接口
* @author ${author}
* @since ${date}
*/
<#if mapperAnnotationClass??>
    @${mapperAnnotationClass.simpleName}
</#if>

@Mapper
public interface ${table.mapperName}  {

    /**
     * 根据条件查询列表
     * @param request
     * @return
     */
    List<${entity}> get${entity}List(${entity} request);

    /**
    * 查询一条数据（查详情）
    * @param request
    * @return
    */
    ${entity} get${entity}One(${entity} request);
    /**
     * 新增
     * @param request
     * @return
     */
    int insert${entity}(${entity} request);
    /**
     * 批量新增
     * @param request
     * @return
     */
    int insertBatch${entity}(@Param("list") List<${entity}> request);
    /**
     * 修改
     * @param request
     * @return
     */
    int update${entity}(${entity} request);
    /**
     * 通过Ids批量修改
     * @param request
     * @return
     */
    int updateBatch${entity}Ids(${entity} request);
    /**
     * 批量修改
     * @param request
     * @return
     */
    int updateBatch${entity}(@Param("list") List<${entity}> request);
    /**
     * 逻辑删除
     * @param request
     * @return
     */
    int delete${entity}(${entity} request);
    /**
     * 批量逻辑删除
     * @param request
     * @return
     */
    int deleteBatch${entity}(${entity} request);
}

