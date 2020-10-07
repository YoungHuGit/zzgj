package com.newerabc.auth.menu.service;

import com.newerabc.auth.menu.entity.Menu;
import com.newerabc.auth.menu.mapper.MenuMapper;
import com.newerabc.auth.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 胡智阳
 * @date 2020-10-03 17:12
 * @desc
 */

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> queryMenusByUser(User user) {
        return menuMapper.queryMenusOwnerRoles(user);
    }
}
