package com.wangjianjie.utils.security;

import com.wangjianjie.utils.utils.R;
import com.wangjianjie.utils.utils.ResponseUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: WangJianjie
 * @Date: 2021/5/6
 * @Description:
 */
public class UnanthEntryPoint implements AuthenticationEntryPoint {
    //AccessDeniedHandler 有权限 但是权限不足


    // 当用户尝试访问安全的REST资源而不提供任何凭据时，将调用此方法发送401 响应 相当于没有登陆
    //未授权统一处理类
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResponseUtils.out(httpServletResponse, R.error());
    }
}
