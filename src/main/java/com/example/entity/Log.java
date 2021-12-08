package com.example.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Log)表实体类
 *
 * @author makejava
 * @since 2021-12-07 16:03:44
 */
@SuppressWarnings("serial")
@Data
@TableName(value = "tbl_log")
public class Log extends Model<Log> {
    //自增主键
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //登录名
    private String loginName;
    //用户名
    private String userName;
    //IP地址
    private String ip;
    //类名
    private String className;
    //方法名
    private String methodName;
    //参数
    private String params;
    //创建时间
    private Date createTime;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }

