package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色和菜单关联表(RoleMenu)表实体类
 *
 * @author makejava
 * @since 2021-12-04 12:30:11
 */
@SuppressWarnings("serial")
@TableName("tbl_role_menu")
@Data
public class RoleMenu extends Model<RoleMenu> {

    //角色ID
    private Integer roleId;
    //菜单ID
    private Integer menuId;


}

