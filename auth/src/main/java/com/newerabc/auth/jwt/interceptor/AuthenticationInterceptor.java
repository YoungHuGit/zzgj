package com.newerabc.auth.jwt.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.newerabc.auth.common.Constants;
import com.newerabc.auth.common.exception.BusinessException;
import com.newerabc.auth.common.utils.RedisUtil;
import com.newerabc.auth.jwt.my_annotation.PassToken;
import com.newerabc.auth.user.entity.User;
import com.newerabc.auth.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author 胡智阳
 * @Date 2020/4/11 14:36
 * @Describe
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    private String token = "token";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        // 执行认证
        if (token == null) {
            throw new BusinessException(Constants.ERROR,"无token，请重新登录");
        }
        // 获取 token 中的 username
        String username;
        try {
            username = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new BusinessException(500,"token解析失败，请重新登录");
        }
        // 验证 token
        String redisToken = (String) redisUtil.hget(token,username);
        if (StringUtil.isEmpty(redisToken)){
            throw new BusinessException(Constants.ERROR,"用户不存在，请重新登录");
        }
        if (!token.equals(redisToken)){
            throw new BusinessException(Constants.ERROR,"token无效，请重新登录");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
