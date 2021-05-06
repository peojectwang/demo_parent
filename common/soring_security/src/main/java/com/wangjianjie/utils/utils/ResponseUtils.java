package com.wangjianjie.utils.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;

/**
 * @Auther: WangJianjie
 * @Date: 2021/5/6
 * @Description:
 */
public class ResponseUtils {

    public static void out(HttpServletResponse response, R r) {
        ObjectMapper mapper = new ObjectMapper();
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        try {
            mapper.writeValue(response.getWriter(), r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
