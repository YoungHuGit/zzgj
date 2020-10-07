package com.newerabc.auth.user.mapper;

import com.newerabc.auth.user.entity.TdUserPage;
import com.newerabc.auth.user.entity.User;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author 胡智阳
 * @date 2020-10-03 14:06
 * @desc
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询用户列表分页
     * @param page
     * @return
     */
    List<User> queryList(TdUserPage page);

    /**
     * 根据用户名密码查询用户信息
     * @param loginUser
     * @return
     */
    User queryUserByUsernamePassword(User loginUser);
}
