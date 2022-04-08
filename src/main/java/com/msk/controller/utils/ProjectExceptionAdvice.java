package com.msk.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//异常处理
@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler
    public R doException(Exception e){

        //记录日志等等


        e.printStackTrace();
        return new R(false,"服务器出现故障，请稍后再试");
    }
}
