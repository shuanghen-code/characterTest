package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.MenuDao;
import com.example.entity.Menu;
import com.example.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 菜单权限表(Menu)表服务实现类
 *
 * @author makejava
 * @since 2021-12-02 19:17:50
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements MenuService {
    @Resource
    private MenuDao menuDao;

    /**
     * 查询当前用户对应的菜单管理内容，并返回一级菜单和二级菜单对应的map对象
     * @param loginName
     * @return
     */
    @Override
    public List<Menu>  findMenuByLoginUser(String loginName) {
        return menuDao.findMenuByLoginUser(loginName);
    }

    /**
     * 查询当前用户对应的菜单管理权限
     * @param loginName
     * @return
     */
    @Override
    public Set<String> queryAllPermsByloginName(String loginName) {
        List<Menu> menuList = menuDao.findMenuByLoginUser(loginName);
        Set<String> perms = new HashSet<>();
        for (Menu menu : menuList) {
            String perm =menu.getPerms();
            if (perm != null && perm.length()>0) {
                perms.add(perm);
            }
        }
        return perms;
    }


    @Override
    public List<Menu> selectAllMenu() {
        return menuDao.selectAllMenu();
    }

    @Override
    public boolean insertMenu(Menu menu) {
        return menuDao.insertMenu(menu);
    }

    @Override
    public Menu findParentNameId(int menuId) {
        return menuDao.findParentNameId(menuId);
    }

    @Override
    public Menu findMenuById(int menuId) {
        return menuDao.findMenuById(menuId);
    }

    @Override
    public boolean updateMenu(Menu menu) {
        return menuDao.updateMenu(menu);
    }

    @Override
    public boolean deleteMenu(int menuId) {
        return menuDao.deleteMenu(menuId);
    }
}

