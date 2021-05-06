package com.wangjianjie.utils.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: WangJianjie
 * @Date: 2021/5/6
 * @Description:
 */
@Data
public class R {

    private Boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<>();


    private R(){}

    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(20000);
        r.setMessage("成功");
        return r;
    }

    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(20001);
        r.setMessage("失败");
        return r;
    }

}
