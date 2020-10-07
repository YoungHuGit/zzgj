package com.newerabc.auth.user.entity;

import com.newerabc.auth.dept.entity.Dept;
import com.newerabc.auth.role.entity.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * @author 胡智阳
 * @date 2020-10-03 14:06
 * @desc
 */

@ApiModel(value = "mapper/user",description = "用户实体类")
@Data
@Table(name = "td_user")
public class User {

    @ApiModelProperty("用户编号")
    @Id
    @Column(name = "user_no")
    private String userNo;

    @ApiModelProperty("用户名")
    @Column(name = "username")
    private String userName;

    @ApiModelProperty("真实姓名")
    @Column(name = "nickname")
    private String nickName;

    @ApiModelProperty("状态")
    @Column(name = "status")
    private String status;

    @ApiModelProperty("用户密码")
    @Column(name = "password")
    private String password;

    @ApiModelProperty("创建时间")
    @Column(name = "createtime")
    private String createTime;

    @ApiModelProperty("年龄")
    @Column(name = "age")
    private int age;

    @ApiModelProperty("角色列表")
    @Transient
    private List<Role> roles;

    @ApiModelProperty("部门")
    @Transient
    private Dept dept;

}
