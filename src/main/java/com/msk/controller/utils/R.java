package com.msk.controller.utils;

import lombok.Data;

//使前后端传送数据统一
@Data
public class R {
    private boolean flag;
    private Object object;
    private String msg;

    public R(){

    }

    public R(boolean flag){
        this.flag = flag;
    }

    public R(boolean flag,Object object){
        this.flag = flag;
        this.object = object;
    }

    public R(boolean flag,String msg){
        this.flag = flag;
        this.msg = msg;
    }
}
