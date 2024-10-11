package com.xt.business.sys.domain.entity;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
* <p>
    * 角色表
    * </p>
*
* @author chai
* @since 2024-10-02
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Role对象", description = "角色表")
public class Role implements Serializable {

    @ApiModelProperty(value = "可以传入主键集合", required = true)
    private List<Long> ids;
    @ApiModelProperty("角色id")
    private Long roleId;
    @ApiModelProperty("角色标识")
    private String roleLabel;
    @ApiModelProperty("角色名字")
    private String roleName;
    @ApiModelProperty("排序")
    private Integer sort;
    @ApiModelProperty("状态：0：可用，1：不可用")
    private Integer status;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("是否删除：0: 未删除，1：已删除")
    private Integer deleted;
    @ApiModelProperty("创建者")
    private String creator;
    @ApiModelProperty("更新者")
    private String updater;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("修改时间")
    private Date updateTime;
}
