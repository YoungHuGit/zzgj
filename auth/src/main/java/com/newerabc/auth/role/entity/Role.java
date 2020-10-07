package com.newerabc.auth.role.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 胡智阳
 * @date 2020-10-03 14:51
 * @desc
 */
@Data
@ApiModel("角色实体类")
@Table(name = "td_role")
public class Role {

    @ApiModelProperty("角色名称")
    @Id
    @Column(name = "id")
    private String id;

    @ApiModelProperty("角色名称")
    @Column(name = "name")
    private String name;

    @ApiModelProperty("角色状态")
    @Column(name = "status")
    private String status;

    @ApiModelProperty("角色描述")
    @Column(name = "desciption")
    private String desciption;

    @ApiModelProperty("创建时间")
    @Column(name = "createtime")
    private String createTime;

}
