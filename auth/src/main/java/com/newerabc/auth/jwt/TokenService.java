package com.newerabc.auth.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.newerabc.auth.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author 胡智阳
 * @Date 2020/4/11 15:24
 * @Describe
 */
@Service("TokenService")
public class TokenService {

    /*设置过期时间*/
    private Integer time=1000;

    public String getToken(User user) {
        String token="";
        Date date = new Date(System.currentTimeMillis() + time*60*1000l);
        token= JWT.create()
                .withAudience(user.getUserName())// 将 username 保存到 token 里面
                .withExpiresAt(date)      //设置token超时时间*/
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}