package com.xt.business.sys.domain.entity;

import java.io.Serializable;
import java.util.Date;

import com.google.common.collect.Lists;
import com.xt.business.sys.controller.response.MenuResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
* <p>
    * 用户表
    * </p>
*
* @author chai
* @since 2024-10-02
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User对象", description = "用户表")
public class User implements Serializable {

    @ApiModelProperty(value = "可以传入主键集合", required = true)
    private List<Long> ids;
    @ApiModelProperty("用户ID")
    private Long id;
    @ApiModelProperty("用户账号")
    private String username;
    @ApiModelProperty("用户昵称")
    private String nickname;
    @ApiModelProperty("用户邮箱")
    private String email;
    @ApiModelProperty("手机号码")
    private String mobile;
    @ApiModelProperty("用户性别（0男 1女 2未知）")
    private Integer sex;
    @ApiModelProperty("头像地址")
    private String avatar;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("帐号状态（0正常 1停用）")
    private Integer status;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("是否删除：0: 未删除，1：已删除")
    private Integer deleted;
    @ApiModelProperty("创建者")
    private String creator;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新者")
    private String updater;
    @ApiModelProperty("更新时间")
    private Date updateTime;

    private List<Role> roleList = Lists.newArrayList();
    private List<String> perms = Lists.newArrayList();
}
