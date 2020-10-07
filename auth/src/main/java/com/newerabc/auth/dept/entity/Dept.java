package com.newerabc.auth.dept.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author 胡智阳
 * @date 2020-10-03 14:52
 * @desc
 */

@Data
@ApiModel("部门实体类")
public class Dept {

    @Id
    @Column(name = "deptno")
    @ApiModelProperty(name = "部门编号")
    private String deptNo;

    @Column(name = "name")
    @ApiModelProperty(name = "部门名称")
    private String name;

    @Column(name = "num")
    @ApiModelProperty(name = "部门人数")
    private int num;

    @Column(name = "addr")
    @ApiModelProperty(name = "部门地址")
    private int addr;
}
