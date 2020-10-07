package com.newerabc.auth.user.controller;

import com.github.pagehelper.PageInfo;
import com.newerabc.auth.common.Constants;
import com.newerabc.auth.common.exception.BusinessException;
import com.newerabc.auth.common.resp.JsonResultUtil;
import com.newerabc.auth.common.resp.Result;
import com.newerabc.auth.common.utils.RedisUtil;
import com.newerabc.auth.jwt.TokenService;
import com.newerabc.auth.jwt.my_annotation.PassToken;
import com.newerabc.auth.menu.entity.Menu;
import com.newerabc.auth.menu.service.MenuService;
import com.newerabc.auth.user.entity.TdUserPage;
import com.newerabc.auth.user.entity.User;
import com.newerabc.auth.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author 胡智阳
 * @date 2020-10-03 14:05
 * @desc
 */

@RestController
@RequestMapping("user")
@Api(tags = "用户管理")
public class UserController {

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private TokenService tokenService;


    @PostMapping("login")
    @ApiOperation(value = "登录")
    @PassToken
    public Result login(@RequestBody User loginUser){
        Map<String, Object> result = new HashMap<>();
        //查询用户
        User user = userService.queryUserByUsernamePassword(loginUser);
        if (user == null){
            log.warn("【登录失败】：用户名="+loginUser.getUserName()+",密码="+loginUser.getPassword());
            throw new BusinessException(Constants.ERROR,"用户名或密码错误,登录失败");
        }
        //查询菜单权限信息
        List<Menu> menus = menuService.queryMenusByUser(user);
        //生成token
        String token = tokenService.getToken(user);
        redisUtil.hset(Constants.TOKEN,user.getUserName(),token);
        result.put(Constants.TOKEN,token);
        result.put("user",user);
        result.put("menus",menus);
        log.info("登录成功");
        return JsonResultUtil.sucess(result);
    }

    @PostMapping("queryList")
    @ApiOperation(value = "查询用户列表")
    public Result queryList(@RequestBody TdUserPage page){
        PageInfo list = userService.queryList(page);
        return JsonResultUtil.sucess(list);
    }

}
