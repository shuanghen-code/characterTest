package com.example.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 菜单权限表(Menu)表实体类
 *
 * @author makejava
 * @since 2021-12-02 19:17:49
 */
@SuppressWarnings("serial")
@TableName("tbl_menu")
@Data
public class Menu extends Model<Menu> {
    //菜单ID
    @TableId(value = "menu_id" ,type = IdType.AUTO)
    private Integer menuId;
    //菜单名称
    private String menuName;
    //父菜单ID
    private Integer parentId;
    //显示顺序
    private Integer orderNum;
    //请求地址
    private String url;
    //菜单类型（M目录 C菜单 F按钮）
    private String menuType;
    //菜单状态（0显示 1隐藏）
    private String visible;
    //权限标识
    private String perms;
    //菜单图标
    private String icon;
    //创建者
    private String createBy;
    //创建时间
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    private Date updateTime;
    //备注
    private String remark;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.menuId;
    }
    }

