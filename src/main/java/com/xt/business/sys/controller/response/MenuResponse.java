package com.xt.business.sys.controller.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
* <p>
    * 菜单表
    * </p>
*
* @author chai
* @since 2024-10-02
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "MenuResponse对象", description = "菜单表")
public class MenuResponse implements Serializable {

    @ApiModelProperty("主键")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @ApiModelProperty("父id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    @ApiModelProperty("菜单名")
    private String menuName;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("类型：0，目录，1菜单，2：按钮")
    private Integer menuType;

    @ApiModelProperty("路由路径   umsUser")
    private String path;

    @ApiModelProperty("组件路径  如：/user/index")
    private String componentPath;

    @ApiModelProperty("权限标识")
    private String perms;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("状态：0：可用，1：不可用")
    private Integer status;

    @ApiModelProperty("是否删除：0: 未删除，1：已删除")
    private Integer deleted;

    @ApiModelProperty("创建者")
    private String creator;

    @ApiModelProperty("更新者")
    private String updater;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private List<MenuResponse> children = Lists.newArrayList();
}