package com.gjq.generator.exception;


import com.gjq.generator.vo.RespBeam;
import com.gjq.generator.vo.RespBeanEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public RespBeam ExceptionHandler(Exception e){
        if(e instanceof GlobalException){
            GlobalException ex=(GlobalException) e;
            return  RespBeam.error(ex.getRespBeanEnum());
        }else if(e instanceof BindException){
            BindException ex=(BindException) e;
            RespBeam respBeam = RespBeam.error(RespBeanEnum.BIND_ERROR);
            respBeam.setMessage("参数校验异常："+ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
       return  respBeam;
        }
        return RespBeam.error(RespBeanEnum.ERROR);
    }
}
