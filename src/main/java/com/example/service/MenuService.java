package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 菜单权限表(Menu)表服务接口
 *
 * @author makejava
 * @since 2021-12-02 19:17:49
 */
public interface MenuService extends IService<Menu> {

    /**
     * 查询当前用户对应的菜单管理内容
     * @param loginName
     * @return
     */
    List<Menu> findMenuByLoginUser(String loginName);

}

