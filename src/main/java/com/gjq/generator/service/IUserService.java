package com.gjq.generator.service;

import com.gjq.generator.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gjq.generator.vo.LoginVo;
import com.gjq.generator.vo.RespBeam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author gjq
 * @since 2022-11-08
 */
public interface IUserService extends IService<User> {

    /**
     * @Author: gjq
     * @Description:登录
     * @Date: 2022/11/9  9:40
     */
    RespBeam doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

/**
 * @Author: gjq
 * @Description:根据cookie获取用户对象
 * @Date: 2022/11/11  9:35
 */
    User getUserByCookie(String userTicket,HttpServletRequest request,HttpServletResponse response);
}
