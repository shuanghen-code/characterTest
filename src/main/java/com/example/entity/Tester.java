package com.example.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Tester)表实体类
 *
 * @author makejava
 * @since 2021-11-26 17:27:49
 */
@SuppressWarnings("serial")
@TableName("tbl_character_tester")
@Data
public class Tester extends Model<Tester> {
    //主键，自增
    @TableId(value = "tester_id" ,type = IdType.AUTO)
    private Integer testerId;
    //手机号应该时唯一的
    private String phonenum;
    //测试人姓名
    private String testerName;
    //测试时间
    private Date testTime;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.testerId;
    }
    }

