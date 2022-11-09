package com.gjq.generator.controller;


import com.gjq.generator.service.IUserService;
import com.gjq.generator.vo.LoginVo;
import com.gjq.generator.vo.RespBeam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @Author: gjq
 * @Description:登录
 * @Date: 2022/11/8  15:06
 */

@Controller
@RequestMapping("/login")
@Slf4j   //输出日志的


/**
 * @Author: gjq
 * @Description:跳转登录界面
 * @Date: 2022/11/8  15:11
 */
public class LoginController {

    @Autowired
    private IUserService userService;


    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }


    /**
     * @Author: gjq
     * @Description:登录功能
     * @Date: 2022/11/9  9:30
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBeam doLogin( @Valid LoginVo loginVo) {

    return userService.doLogin(loginVo);

    }

}
