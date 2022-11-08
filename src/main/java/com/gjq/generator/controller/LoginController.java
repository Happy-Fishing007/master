package com.gjq.generator.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gjq
 * @Description:登录
 * @Date: 2022/11/8  15:06
 */

@RestController
@RequestMapping("/login")
@Slf4j   //输出日志的


/**
 * @Author: gjq
 * @Description:跳转登录界面
 * @Date: 2022/11/8  15:11
 */
public class LoginController {
  @RequestMapping("/toLogin")
    public String toLogin(){
      return  "login";
  }
}
