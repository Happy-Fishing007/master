package com.gjq.generator.controller;


import com.gjq.generator.pojo.User;
import com.gjq.generator.service.IGoodsService;
import com.gjq.generator.service.IUserService;
import com.gjq.generator.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/toList")
    public String toList( Model model,User user) {
//        if (StringUtils.isEmpty(ticket)) {
//            return "login";
//        }
////        User user = (User) session.getAttribute(ticket);
//        User user = userService.getUserByCookie(ticket, request, response);
//        if (null == user) {
//            return "login";
//        }

        model.addAttribute("user", user);
        List<GoodsVo> goodsVo = goodsService.findGoodsVo();
        System.out.println(goodsVo);
        model.addAttribute("goodsList",goodsService.findGoodsVo());
        return "goodsList";
    }
}
