package ${package.Entity?replace(".entity","")}.dto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
/**
* @author ${author}
* @since ${date}
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "${entity}DTO对象", description = "${table.comment!}")
public class ${entity}DTO implements Serializable {

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.keyFlag>
    @ApiModelProperty(value = "可以传入主键集合", required = true)
    private Set<${field.propertyType}> ${field.propertyName}s;
    @ApiModelProperty("${field.comment}")
    private ${field.propertyType} ${field.propertyName};
    <#else >
    @ApiModelProperty("${field.comment}")
    private ${field.propertyType} ${field.propertyName};
    </#if>
</#list>
}
