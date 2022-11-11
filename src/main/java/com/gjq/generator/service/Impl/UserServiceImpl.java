package com.gjq.generator.service.Impl;

import com.gjq.generator.exception.GlobalException;
import com.gjq.generator.pojo.User;
import com.gjq.generator.mapper.UserMapper;
import com.gjq.generator.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjq.generator.utils.CookieUtil;
import com.gjq.generator.utils.MD5Utils;
import com.gjq.generator.utils.UUIDUtil;
import com.gjq.generator.vo.LoginVo;
import com.gjq.generator.vo.RespBeam;
import com.gjq.generator.vo.RespBeanEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author gjq
 * @since 2022-11-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @Author: gjq
     * @Description:登录
     * @Date: 2022/11/9  9:41
     */
    @Override
    public RespBeam doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();

//        if(StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
//            return  RespBeam.error(RespBeanEnum.LOGIN_ERROR);
//        }
//        if(!ValidatorUtil.isMobile(mobile)){
//            return RespBeam.error(RespBeanEnum.MOBILE_ERROR);
//        }
        //根据手机号去取密码
        User user = userMapper.selectById(mobile);
        if (user == null) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        if (!MD5Utils.fromPassToBasePass(password, user.getSlat()).equals(user.getPassword())) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        //生成cookie
        String ticket = UUIDUtil.uuid();
        // request.getSession().setAttribute(ticket,user);
        //将用户信息存入redis
        redisTemplate.opsForValue().set("user：" + ticket, user);
        CookieUtil.setCookie(request, response, "userTicket", ticket);
        return RespBeam.success();
    }

    @Override
    public User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(userTicket)){
            return  null;
        }
        User user = (User) redisTemplate.opsForValue().get("user：" + userTicket);
        if(user!=null){
            CookieUtil.setCookie(request, response, "userTicket", userTicket);
        }
        return user;
    }
}
