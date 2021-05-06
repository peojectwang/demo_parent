package com.wangjianjie.utils.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: WangJianjie
 * @Date: 2021/5/6
 * @Description:
 */
public class TokenLogoutHandler implements LogoutHandler {

    private TokenManager manager;

    private Redis redis;


    public TokenLogoutHandler(TokenManager manager, Redis redis) {
        this.manager = manager;
        this.redis = redis;
    }

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        //1 从header 获取token

        //2token不为空,从redis里删除token 删除登陆后记录的相关信息

    }
}
