package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("tbl_character_manager")
@Data
public class Manager {
    private int mid;
    @TableField(value = "name")
    private String mname;

    @TableField(value = "password")
    private String mpassword;

    @Override
    public String toString() {
        return "Manager{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", mpassword='" + mpassword + '\'' +
                '}';
    }
}
