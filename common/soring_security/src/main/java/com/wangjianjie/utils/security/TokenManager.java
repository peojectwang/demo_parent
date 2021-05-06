package com.wangjianjie.utils.security;

import com.wangjianjie.utils.utils.R;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: WangJianjie
 * @Date: 2021/5/6
 * @Description:
 */
@Component
public class TokenManager {

    //token有效时间
    private long tokenExpired = 24 * 60 * 60 * 1000;

    private String tokenSignKey = "123456";

    //根据用户名生成token
    public String createToken(String userName) {
        String token = Jwts.builder().setSubject(userName).setExpiration(new Date(System.currentTimeMillis() + tokenExpired)).signWith(SignatureAlgorithm.HS512, tokenSignKey).compact();
        return token;
    }


    //根据token得到用户信息
    public String getUserInfo(String token) {
        String userInfo = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws().getBody().getSubject();
        return userInfo;
    }

//    删除Token
    public void removeToken(String tokenSignKey) {

    }

}
