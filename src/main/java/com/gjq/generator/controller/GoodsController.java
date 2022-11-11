package com.gjq.generator.controller;


import com.gjq.generator.pojo.User;
import com.gjq.generator.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: gjq
 * @Description:跳转到商品列表页
 * @Date: 2022/11/10  11:21
 */

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model, @CookieValue("userTicket") String ticket) {
        if (StringUtils.isEmpty(ticket)) {
            return "login";
        }
//        User user = (User) session.getAttribute(ticket);
        User user = userService.getUserByCookie(ticket, request, response);
        if (null == user) {
            return "login";
        }
        model.addAttribute("user", user);
        return "goodsList";
    }
}
