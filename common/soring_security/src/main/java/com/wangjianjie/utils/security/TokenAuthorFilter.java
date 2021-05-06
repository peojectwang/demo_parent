package com.wangjianjie.utils.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: WangJianjie
 * @Date: 2021/5/6
 * @Description:
 */
public class TokenAuthorFilter extends BasicAuthenticationFilter {

    public TokenAuthorFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    public TokenAuthorFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationManager, authenticationEntryPoint);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取权限信息
        //自定义实现此方法可以改变获取authen的方式 更具header里的字段取出值  自己定义的header的属性值时什么根据实际情况去解析出需要的值 然后去redis里面获取什么
        Authentication authentication = getAuth(request);

        //将权限信息放入上下文中
        SecurityContextHolder.getContext().setAuthentication(authentication);

        super.doFilterInternal(request, response, chain);
    }
}
