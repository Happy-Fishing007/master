package com.gjq.generator.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum RespBeanEnum {
    //通用模块异常
    SUCCESS(200, "成功"),
    ERROR(500, "服务端异常"),
    //登录模块
    LOGIN_ERROR(500210,"登录密码或者账号错误"),
    MOBILE_ERROR(500211,"手机号格式不正确"),
    //绑定异常
    BIND_ERROR(500212,"参数校验异常");
    private final Integer code;
    private final String message;

    RespBeanEnum(Integer code, String success) {
        this.code = code;
        this.message = success;
    }
}
