package com.example.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.LayUiTree;
import com.example.entity.Menu;
import com.example.entity.ReturnBean;
import com.example.service.MenuService;
import com.example.util.TreeUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 菜单权限表(Menu)表控制层
 *
 * @author makejava
 * @since 2021-12-02 19:17:49
 */
@RestController
@RequestMapping("menu")
public class MenuController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;

    @GetMapping("findAllMenu")
    public List<LayUiTree> findAllMenu(){
        List<Menu> menus = menuService.list();
        List<LayUiTree> treeList = TreeUtils.getChildPerms(menus, 0);
//        for (LayUiTree tree : treeList) {
//            System.out.println(tree.toString()+"============----------");
//        }
        if (treeList.size()>0){
            return treeList;
        } else {
            return null;
        }
    }

}

