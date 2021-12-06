package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 菜单权限表(Menu)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-02 19:17:49
 */
public interface MenuDao extends BaseMapper<Menu> {
    /**
     * 查询当前用户对应的菜单管理内容
     * @param loginName
     * @return
     */
    List<Menu> findMenuByLoginUser(@Param("loginName") String loginName);

    List<Menu> selectAllMenu();
    boolean  insertMenu(@Param("menu") Menu menu);
    Menu findParentNameId(int menuId);
    Menu findMenuById(int menuId);
    boolean updateMenu(Menu menu);
    boolean deleteMenu(int menuId);

}

