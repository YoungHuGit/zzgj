package com.newerabc.auth.user.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newerabc.auth.user.entity.TdUserPage;
import com.newerabc.auth.user.entity.User;
import com.newerabc.auth.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 胡智阳
 * @date 2020-10-03 14:06
 * @desc
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public PageInfo queryList(TdUserPage page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        List<User> list = userMapper.queryList(page);
        return new PageInfo<>(list);
    }

    public User queryUserByUsernamePassword(User loginUser) {
        return userMapper.queryUserByUsernamePassword(loginUser);
    }
}
