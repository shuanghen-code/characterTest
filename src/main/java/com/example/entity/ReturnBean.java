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

    @Override
    public String toString() {
        return "ReturnBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
