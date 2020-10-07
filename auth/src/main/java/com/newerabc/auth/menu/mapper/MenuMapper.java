package com.newerabc.auth.menu.mapper;

import com.newerabc.auth.menu.entity.Menu;
import com.newerabc.auth.user.entity.User;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author 胡智阳
 * @date 2020-10-03 17:14
 * @desc
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 查询权限对应的角色
     * @param user
     * @return
     */
    List<Menu> queryMenusOwnerRoles(User user);
}
