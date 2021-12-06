package com.example.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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

    @TableId(value = "menu_id" ,type = IdType.AUTO)
    private Integer menuId;
    @TableField(value = "menu_name")
    private String menuName;
    @TableField(value = "parent_id")
    private Integer parentId;
    @TableField(value = "order_num")
    private Integer orderNum;
    private String url;
    @TableField(value = "menu_type")
    private char menuType;
    private char visible;
    private String perms;
    private String icon;
    @TableField(value = "create_by")
    private String createBy;
    @TableField(value = "create_time")
    private Date  createTime;
    @TableField(value = "update_by")
    private String updateBy;
    @TableField(value = "update_time")
    private Date updateTime;
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

