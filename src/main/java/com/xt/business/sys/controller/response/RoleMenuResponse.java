package com.xt.business.sys.controller.response;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
* <p>
    * 角色菜单关联表
    * </p>
*
* @author chai
* @since 2024-10-02
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "RoleMenuResponse对象", description = "角色菜单关联表")
public class RoleMenuResponse implements Serializable {

    @ApiModelProperty("")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @ApiModelProperty("")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roleId;

    @ApiModelProperty("")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long menuId;

}
