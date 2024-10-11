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
@ApiModel(value = "RoleMenuDTO对象", description = "角色菜单关联表")
public class RoleMenuDTO implements Serializable {

    @ApiModelProperty(value = "可以传入主键集合", required = true)
    private List<Long> ids;
    @ApiModelProperty("")
    private Long id;
    @ApiModelProperty("")
    private Long roleId;
    @ApiModelProperty("")
    private Long menuId;
}
