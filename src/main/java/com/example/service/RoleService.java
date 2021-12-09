package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Role;

import java.util.List;

/**
 * 角色信息表(Role)表服务接口
 *
 * @author makejava
 * @since 2021-12-02 14:58:24
 */
public interface RoleService extends IService<Role> {
    // 根据roleId查询对应的菜单，必须为三级菜单，否则layuitree无法半选
    List<Integer> findMenuIdsByRoleId(Integer roleId);

}

