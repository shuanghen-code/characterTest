package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户和角色关联表(UserRole)表实体类
 *
 * @author makejava
 * @since 2021-12-07 15:03:21
 */
@SuppressWarnings("serial")
@TableName("tbl_user_role")
@Data
public class UserRole extends Model<UserRole> {
    //用户ID
    private Integer userId;
    //角色ID
    private Integer roleId;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
    }

