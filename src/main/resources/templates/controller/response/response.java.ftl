package ${package.Controller}.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
* <p>
    * ${table.comment!}
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "${entity}Response对象", description = "${table.comment!}")
public class ${entity}Response implements Serializable {

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if  field.propertyType == "Long">
    @ApiModelProperty("${field.comment}")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private ${field.propertyType} ${field.propertyName};
    <#elseif field.propertyType == "Date">
    @ApiModelProperty("${field.comment}")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private ${field.propertyType} ${field.propertyName};
    <#else>
    @ApiModelProperty("${field.comment}")
    private ${field.propertyType} ${field.propertyName};
    </#if>

</#list>
}
