package com.gjq.generator.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBeam {
    private long code;
    private String message;
    private Object obj;

    /**
     * @Author: gjq
     * @Description:成功的返回结果
     * @Date: 2022/11/8  15:56
     */
    public static RespBeam success() {
        return new RespBeam(RespBeanEnum.SUCCESS.getCode(), RespBeam.success().getMessage(), null);
    }
    public static RespBeam success(Object obj) {
        return new RespBeam(RespBeanEnum.SUCCESS.getCode(), RespBeam.success().getMessage(), obj);
    }
    /**
     * @Author: gjq
     * @Description:失败的返回结果
     * @Date: 2022/11/8  15:59
     */
    public static RespBeam error(RespBeanEnum respBeanEnum) {
        return new RespBeam(respBeanEnum.getCode(),respBeanEnum.getMessage(), null);
    }
    public static RespBeam error(RespBeanEnum respBeanEnum,Object obj) {
        return new RespBeam(respBeanEnum.getCode(),respBeanEnum.getMessage(), obj);
    }
}
