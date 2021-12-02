package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.MenuDao;
import com.example.entity.Menu;
import com.example.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    /*@Override
    public Map<String, Object> findMenuByLoginUser(String loginName) {
        Map<String, Object> map = new HashMap<>();
        //根据用户名查询所有的一级菜单
        List<Map<String, Object>> firstMenus= new ArrayList<>();
        //根据用户名查询所有的二级菜单
        List<Map<String, Object>> secondMenus= new ArrayList<>();
        //查询所有的菜单根据登录名
        List<Map<String, Object>> menus = menuDao.findMenuByLoginUser(loginName);

        // 开始菜单分类
        for (Map<String, Object> menu: menus) {
            String menuType = menu.get("menu_type").toString();
            if (menuType.equals("M")){
                firstMenus.add(menu);
            } else if (menuType.equals("C")) {
                secondMenus.add(menu);
            }
        }
        map.put("firstMenus",  firstMenus);
        map.put("secondMenus", secondMenus);
        return map;
    }*/
}

