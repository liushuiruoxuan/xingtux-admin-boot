package ${package.ServiceImpl};

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import com.google.common.collect.Lists;
import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import ${package.Controller}.request.${entity}Request;
import ${package.Controller}.response.${entity}Response;
import ${commonPackagePath}.common.PageResponse;
import ${commonPackagePath}.common.PageRequest;
import ${package.Service}.${table.serviceName};
import ${package.Mapper}.${table.mapperName};
import ${package.Entity}.${entity};
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import java.util.List;
/**
* ${table.comment!} 服务实现类
*
* @author ${author}
* @since ${date}
*/
@Service
public class ${table.serviceImplName} implements ${table.serviceName}{
    @Resource
    private ${table.mapperName} ${table.mapperName?uncap_first};
    @Override
    public List<${entity}Response> get${entity}List(${entity}Request request) {
      List<${entity}> ${entity?uncap_first}List = ${table.mapperName?uncap_first}.get${entity}List(BeanUtil.copyProperties(request, ${entity}.class));
      if (CollectionUtils.isEmpty(${entity?uncap_first}List)) {
        return Lists.newArrayList();
      }
      return BeanUtil.copyToList(${entity?uncap_first}List, ${entity}Response.class);
    }
    @Override
    public PageResponse<${entity}Response> get${entity}Page(PageRequest<${entity}Request> request) {
      PageHelper.startPage(request.getPageNum(), request.getPageSize());
      List<${entity}> ${entity?uncap_first}List = ${table.mapperName?uncap_first}.get${entity}List(BeanUtil.copyProperties(request.getParamData(), ${entity}.class));
      if (CollectionUtils.isEmpty(${entity?uncap_first}List)) {
         return new PageResponse<>(new PageInfo<>(Lists.newArrayList()));
      }
      return new PageResponse<>(BeanUtil.copyProperties(new PageInfo<>(${entity?uncap_first}List),PageInfo.class));
    }
    @Override
    public ${entity}Response get${entity}One(${entity}Request request) {
      ${entity}  ${entity?uncap_first}= ${table.mapperName?uncap_first}.get${entity}One(BeanUtil.copyProperties(request, ${entity}.class));
      if (ObjectUtils.isEmpty(${entity?uncap_first}) ) {
        return new ${entity}Response();
      }
      return BeanUtil.copyProperties(${entity?uncap_first}, ${entity}Response.class);
    }


    @Override
    public int insert${entity}(${entity}Request request) {
        return ${table.mapperName?uncap_first}.insert${entity}(BeanUtil.copyProperties(request, ${entity}.class));
    }

    @Override
    public int insertBatch${entity}(List<${entity}Request> request) {
      return ${table.mapperName?uncap_first}.insertBatch${entity}(BeanUtil.copyToList(request, ${entity}.class));
    }

    @Override
    public int update${entity}(${entity}Request request) {
      return ${table.mapperName?uncap_first}.update${entity}(BeanUtil.copyProperties(request, ${entity}.class));
    }



    @Override
    public int updateBatch${entity}(List<${entity}Request> request) {
      return ${table.mapperName?uncap_first}.updateBatch${entity}(BeanUtil.copyToList(request, ${entity}.class));
    }

    @Override
    public int delete${entity}(${entity}Request request) {
      return ${table.mapperName?uncap_first}.delete${entity}(BeanUtil.copyProperties(request, ${entity}.class));
    }

    @Override
    public int deleteBatch${entity}(${entity}Request request) {
      return ${table.mapperName?uncap_first}.deleteBatch${entity}(BeanUtil.copyProperties(request, ${entity}.class));
    }
}