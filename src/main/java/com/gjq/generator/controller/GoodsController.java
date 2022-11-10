package com.gjq.generator.controller;


import com.gjq.generator.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: gjq
 * @Description:跳转到商品列表页
 * @Date: 2022/11/10  11:21
 */

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @RequestMapping("/toList")
    public String toList(HttpSession session, Model model, @CookieValue("userTicket") String ticket) {
        if (StringUtils.isEmpty(ticket)) {
            return "login";
        }
        User user = (User) session.getAttribute(ticket);
        if (null == user) {
            return "login";
        }
        model.addAttribute("user", user);
        System.out.println(user.getUsername());
        return "goodsList";
    }
}
