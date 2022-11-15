package com.gjq.generator.config;

import com.gjq.generator.pojo.User;
import com.gjq.generator.service.IUserService;
import com.gjq.generator.utils.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Author: gjq
 * @Description:自定义用户参数
 * @Date: 2022/11/11  10:08
 */
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private IUserService userService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> type = methodParameter.getParameterType();
        return type== User.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        String userTicket = CookieUtil.getCookieValue(request, "userTicket");
        if(StringUtils.isEmpty(userTicket)){
            return  null;
        }
        return userService.getUserByCookie(userTicket,request,response);
    }
}
