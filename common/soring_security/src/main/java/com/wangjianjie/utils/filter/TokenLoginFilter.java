package com.wangjianjie.utils.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangjianjie.utils.security.TokenManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Auther: WangJianjie
 * @Date: 2021/5/6
 * @Description: 认证过滤器 继承UsernamePasswordAuthenticationFilter
 */
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {

    private TokenManager tokenManager;

    private Redis redis;

    private AuthenticationManager authenticationManager;

    public TokenLoginFilter(TokenManager tokenManager, Redis redis, AuthenticationManager authenticationManager) {
        this.tokenManager = tokenManager;
        this.redis = redis;
        this.authenticationManager = authenticationManager;
        this.setPostOnly(true);//仅post 提交
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/admin/acl/login", "POST"));

    }

    //获取表单提交的信息 登陆时调用的
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            User user=new ObjectMapper().readValue(request.getInputStream(), User.getClass());
            //用户信息
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("wangjianjie", "99999", new ArrayList<>()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //认证成功的方法
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        Object principal = authResult.getPrincipal();
    }

    //认证失败会调用的方法


    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
