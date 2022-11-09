package com.gjq.generator.vo;


import com.gjq.generator.Validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Author: gjq
 * @Description:登录实体
 * @Date: 2022/11/9  9:26
 */
@Data
public class LoginVo {
    @NotNull
    @IsMobile
    private String mobile;

    @NotNull
    @Length(min = 32)
    private String password;
}
