package ${package.Service};
import ${package.Entity}.${entity};
import ${package.Controller}.request.${entity}Request;
import ${package.Controller}.response.${entity}Response;
import ${commonPackagePath}.common.PageResponse;
import ${commonPackagePath}.common.PageRequest;
import java.util.List;


/**
*
* ${table.comment!} 服务类
* @author ${author}
* @since ${date}
*/
public interface ${table.serviceName}  {
    /**
    * 根据条件查询列表
    * @param request
    * @return
    */
    List<${entity}Response> get${entity}List(${entity}Request request);

    /**
    * 分页查询列表
    * @param request
    * @return
    */
    PageResponse<${entity}Response> get${entity}Page(${entity}Request request);
    /**
    * 查询一条数据（查详情）
    * @param request
    * @return
    */
    ${entity}Response get${entity}One(${entity}Request request);
    /**
    * 新增
    * @param request
    * @return
    */
    int insert${entity}(${entity}Request request);
    /**
    * 批量新增
    * @param request
    * @return
    */
    int insertBatch${entity}(List<${entity}Request> request);
    /**
    * 修改
    * @param request
    * @return
    */
    int update${entity}(${entity}Request request);
    /**
    * 批量修改
    * @param request
    * @return
    */
    int updateBatch${entity}(List<${entity}Request> request);
    /**
    * 逻辑删除
    * @param request
    * @return
    */
    int delete${entity}(${entity}Request request);
    /**
    * 批量逻辑删除
    * @param request
    * @return
    */
    int deleteBatch${entity}(${entity}Request request);
}
