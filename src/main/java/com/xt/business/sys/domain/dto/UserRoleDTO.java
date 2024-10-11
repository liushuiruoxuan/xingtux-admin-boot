package com.xt.business.sys.domain.dto;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
/**
* @author chai
* @since 2024-10-02
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "UserRoleDTO对象", description = "用户角色关联表")
public class UserRoleDTO implements Serializable {

    @ApiModelProperty(value = "可以传入主键集合", required = true)
    private List<Long> ids;
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("用户id")
    private Long userId;
    @ApiModelProperty("角色id")
    private Long roleId;
}
