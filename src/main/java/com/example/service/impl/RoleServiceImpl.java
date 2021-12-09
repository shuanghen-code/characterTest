package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.RoleDao;
import com.example.dao.UserRoleDao;
import com.example.entity.Role;
import com.example.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色信息表(Role)表服务实现类
 *
 * @author makejava
 * @since 2021-12-02 14:58:24
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

    @Resource
    private UserRoleDao userRoleDao;

    /**
     * 根据roleId查询对应的菜单，必须为三级菜单，否则layuitree无法半选
     * @param roleId
     * @return
     */
    @Override
    public List<Integer> findMenuIdsByRoleId(Integer roleId) {
        return userRoleDao.findMenuIdsByRoleId(roleId);
    }
}

