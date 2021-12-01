package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Tester)性格测试者在页面上显示的实体类，带有性格颜色
 *
 * @since 2021-11-26 17:27:49
 */
@SuppressWarnings("serial")
@Data
public class TesterVo extends Model<TesterVo> {
    //主键，自增
    @TableId(value = "tester_id" ,type = IdType.AUTO)
    private Integer testerId;
    //手机号应该时唯一的
    private String phonenum;
    //测试人姓名
    private String testerName;
    //测试时间
    private Date testTime;

    //红色性格的数量
    private Integer redCount;
    //蓝色性格的数量
    private Integer blueCount;
    //黄色性格的数量
    private Integer yellowCount;
    //绿色性格的数量
    private Integer greenCount;



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

