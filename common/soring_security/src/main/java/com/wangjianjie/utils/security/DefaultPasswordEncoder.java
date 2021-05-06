package com.wangjianjie.utils.security;

import com.wangjianjie.utils.utils.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Auther: WangJianjie
 * @Date: 2021/5/6
 * @Description:
 */
@Component
public class DefaultPasswordEncoder implements PasswordEncoder{



    @Override
    public String encode(CharSequence charSequence) {
        return MD5.MD5Encode(charSequence.toString(),"utf8",true);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(MD5.MD5Encode(charSequence.toString(), "utf8", true));
    }
}
