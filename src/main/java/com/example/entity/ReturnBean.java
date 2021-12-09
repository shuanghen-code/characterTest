package com.example.entity;

import lombok.Data;

/**
 * @author ：Teacher陈（86521760@qq.com）
 * @date ：Created in 2021/11/24 15:02
 * @description：layui数据表格专用的实体类
 * @modified By：
 * @version: 1.0
 */
@Data
public class ReturnBean<T>{
    private int code;
    private String msg;
    private Long count;
    private T data;

    public ReturnBean(int code, String msg, Long count, T data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public ReturnBean() {
    }

}
