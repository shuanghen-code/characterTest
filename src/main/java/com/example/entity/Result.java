package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Result)表实体类
 *
 * @author makejava
 * @since 2021-11-26 17:27:32
 */
@SuppressWarnings("serial")
@Data
@TableName("tbl_character_result")
public class Result extends Model<Result> {
    //主键，自增
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;
    //测试人员id
    private Integer testerId;
    //测试题id
    private Integer questionId;
    //对应题目提交结果
    private String result;

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", testerId=" + testerId +
                ", questionId=" + questionId +
                ", result='" + result + '\'' +
                '}';
    }

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

