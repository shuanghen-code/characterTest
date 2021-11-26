package com.example.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Tester)表实体类
 *
 * @author makejava
 * @since 2021-11-26 17:27:49
 */
@SuppressWarnings("serial")
public class Tester extends Model<Tester> {
    //主键，自增
    private Integer testerId;
    //手机号应该时唯一的
    private String phonenum;
    //测试人姓名
    private String testerName;
    //测试时间
    private Date testTime;


    public Integer getTesterId() {
        return testerId;
    }

    public void setTesterId(Integer testerId) {
        this.testerId = testerId;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getTesterName() {
        return testerName;
    }

    public void setTesterName(String testerName) {
        this.testerName = testerName;
    }

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

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

