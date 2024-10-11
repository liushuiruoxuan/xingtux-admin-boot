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
    * 用户角色关联表
    * </p>
*
* @author chai
* @since 2024-10-02
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "UserRoleResponse对象", description = "用户角色关联表")
public class UserRoleResponse implements Serializable {

    @ApiModelProperty("主键id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @ApiModelProperty("用户id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    @ApiModelProperty("角色id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roleId;

}
