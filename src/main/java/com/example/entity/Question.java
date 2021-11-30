package com.example.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 问题表(Question)表实体类
 *
 * @author makejava
 * @since 2021-11-26 17:25:53
 */
@SuppressWarnings("serial")
@TableName("tbl_character_question")
@Data
public class Question extends Model<Question> {
    //问题编号
    @TableId(value = "question_id" ,type = IdType.AUTO)
    private Integer questionId;
    
    private String question;
    
    private String optionA;
    
    private String optionB;
    
    private String optionC;
    
    private String optionD;
    //预留字段
    private Integer type;
    //状态
    private Integer status;
    //创建时间
    private Date createTime;
    //创建人
    private String creator;
    //修改时间
    private Date updateTime;
    //修改人
    private String updater;

    private int flag;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.questionId;
    }
    }

