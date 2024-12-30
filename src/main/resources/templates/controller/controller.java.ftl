package ${package.Controller};

import ${package.Controller}.request.${entity}Request;
import ${package.Controller}.response.${entity}Response;
import ${package.Service}.${table.serviceName};
import ${commonPackagePath}.common.PageRequest;
import ${commonPackagePath}.common.ResponseResult;
import ${commonPackagePath}.common.PageResponse;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* ${table.comment} 控制层
* @author ${author}
* @since ${date}
*/
@Api(tags = "${table.comment}")
@RestController
@RequestMapping("/${table.entityPath}")
public class ${table.controllerName} {

    @Resource
    private ${table.serviceName} ${entity?uncap_first}Service ;

    @ApiOperation(value = "查询列表")
    @PostMapping("/get${entity}List")
    public ResponseResult<List<${entity}Response>> get${entity}List(@RequestBody ${entity}Request request) {
        return ResponseResult.success(${entity?uncap_first}Service.get${entity}List(request));
    }

    @ApiOperation(value = "分页查询列表")
    @PostMapping("/get${entity}Page")
    public ResponseResult<PageResponse<${entity}Response>> get${entity}Page(@RequestBody PageRequest<${entity}Request> request) {
        return ResponseResult.success(${entity?uncap_first}Service.get${entity}Page(request));
    }

    @ApiOperation(value = "查询详情")
    @PostMapping("/get${entity}One")
    public ResponseResult<${entity}Response> get${entity}One(@RequestBody ${entity}Request request) {
        return ResponseResult.success(${entity?uncap_first}Service.get${entity}One(request));
    }

    @ApiOperation(value = "新增")
    @PostMapping("/insert${entity}")
    public ResponseResult<Integer> insert${entity}(@RequestBody ${entity}Request request) {
        return ResponseResult.success(${entity?uncap_first}Service.insert${entity}(request));
    }

    @ApiOperation(value = "批量新增")
    @PostMapping("/insertBatch${entity}")
    public ResponseResult<Integer> insertBatch${entity}(@RequestBody List<${entity}Request> request) {
        return ResponseResult.success(${entity?uncap_first}Service.insertBatch${entity}(request));
    }

    @ApiOperation(value = "修改")
    @PutMapping("/update${entity}")
    public ResponseResult<Integer> update${entity}(@RequestBody ${entity}Request request) {
        return ResponseResult.success(${entity?uncap_first}Service.update${entity}(request));
    }

    @ApiOperation(value = "批量修改")
    @PutMapping("/updateBatch${entity}")
    public ResponseResult<Integer> updateBatch${entity}(@RequestBody List<${entity}Request> request) {
        return ResponseResult.success(${entity?uncap_first}Service.updateBatch${entity}(request));
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/delete${entity}")
    public ResponseResult<Integer> delete${entity}(@RequestBody ${entity}Request request) {
        return ResponseResult.success(${entity?uncap_first}Service.delete${entity}(request));
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/deleteBatch${entity}")
    public ResponseResult<Integer> deleteBatch${entity}(@RequestBody ${entity}Request request) {
        return ResponseResult.success(${entity?uncap_first}Service.deleteBatch${entity}(request));
    }

}