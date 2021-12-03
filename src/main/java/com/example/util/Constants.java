package com.example.util;

/**
 * @description：项目使用的常量类
 * @modified By：
 * @version: 1.0
 */
public class Constants {
    /**
     * 默认分页的起始页
     */
    public static  final Long page=1L;
    /**
     * 默认的分页的pagesize，一页显示多少行
     */
    public static  final Long limit=10L;

    //增删改成功
    public static final int successCode=0;
    //增删改失败
    public static final int failCode=1;
    //加密算法
    public static final String algorithmName="MD5";
    //加密次数
    public static final   int hashIterations=1000;
}
