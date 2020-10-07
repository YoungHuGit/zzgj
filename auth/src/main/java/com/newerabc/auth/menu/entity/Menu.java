package com.newerabc.auth.menu.entity;

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
 * @date 2020-10-03 17:08
 * @desc
 */

@Data
@ApiModel("菜单实体类")
@Table(name = "td_menu")
public class Menu {

    @Id
    @Column(name = "id")
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("标题")
    @Column(name = "title")
    private String title;

    @ApiModelProperty("url")
    @Column(name = "url")
    private String url;

    @ApiModelProperty("父菜单ID")
    @Column(name = "parentid")
    private String parentId;

    @ApiModelProperty("类型：1菜单、2按钮")
    @Column(name = "typeid")
    private String typeId;

    @Transient
    private List<Role> roles;

}
