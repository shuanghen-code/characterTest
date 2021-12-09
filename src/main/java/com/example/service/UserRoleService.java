package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.UserRole;

import java.util.List;

/**
 * 用户和角色关联表(UserRole)表服务接口
 *
 * @author makejava
 * @since 2021-12-07 15:03:22
 */
public interface UserRoleService extends IService<UserRole> {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    UserRole queryById(Integer userId);

    /**
     * 通过UserId查询所有数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    List<UserRole> queryByUserId(Integer userId);

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    UserRole insert(UserRole userRole);

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    UserRole update(UserRole userRole);


}

