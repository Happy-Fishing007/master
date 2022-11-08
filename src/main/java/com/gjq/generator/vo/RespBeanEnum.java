package com.gjq.generator.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum RespBeanEnum {

   SUCCESS(200,"成功"),
    ERROR(500,"服务端异常");


    private  final Integer code;
    private  final String message;

    RespBeanEnum(Integer code, String success) {
        this.code = code;
        this.message = success;
    }
}
