package com.example.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 部门表(Dept)表实体类
 *
 * @author makejava
 * @since 2021-12-02 18:25:30
 */
@SuppressWarnings("serial")
@Data
@TableName("tbl_dept")
public class Dept extends Model<Dept> {
    //部门id
    @TableId(value = "dept_id", type = IdType.AUTO)
    private Integer deptId;
    //部门名称
    private String deptName;
    //显示顺序
    private Integer orderNum;
    //部门状态（0正常 1停用）
    private String status;
    //删除标志（0代表存在 2代表删除）
    private String delFlag;
    //创建者
    private String createBy;
    //创建时间
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    private Date updateTime;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.deptId;
    }
}

