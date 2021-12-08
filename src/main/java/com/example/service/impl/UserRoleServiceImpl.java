package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.UserRoleDao;
import com.example.entity.UserRole;
import com.example.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户和角色关联表(UserRole)表服务实现类
 *
 * @author makejava
 * @since 2021-12-07 15:03:22
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {

    @Resource
    private UserRoleDao userRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public UserRole queryById(Integer userId) {
        return this.userRoleDao.queryById(userId);
    }


    /**
     * 通过UserId查询所有角色数据
     *
     * @param userId
     * @return 实例对象
     */
    @Override
    public List<UserRole> queryByUserId(Integer userId) {
        return this.userRoleDao.queryByUserId(userId);
    }


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UserRole> queryAllByLimit(int offset, int limit) {
        return this.userRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole insert(UserRole userRole) {
        this.userRoleDao.insert(userRole);
        return userRole;
    }

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole update(UserRole userRole) {
        this.userRoleDao.update(userRole);
        return this.queryById(userRole.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.userRoleDao.deleteById(userId) > 0;
    }


}

