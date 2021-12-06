package com.example.controller;

import com.example.entity.Menu;
import com.example.entity.ReturnBean;
import com.example.service.MenuService;
import com.example.util.TreeUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
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

    @RequestMapping("/selectAllMenu")
    public ReturnBean selectAllMenu(){
        List<Menu> menuList=menuService.selectAllMenu();
        return super.success(menuList);
    }

    @RequestMapping("/selectAllChildren")
    public ReturnBean selectAllChildren(){
        List<Menu> menuList=menuService.selectAllMenu();
        return super.success(TreeUtils.getChildPerms(menuList, 0));
    }

    @RequestMapping("/insertMenu")
    public ReturnBean insertMenu(@RequestBody Menu menu) {
        menu.setCreateTime(new Date());
        boolean insert = menuService.insertMenu(menu);
        if (insert) {
            return super.success(null);
        } else {
            return super.fail(null);
        }
    }

    @RequestMapping("/deleteMenu")
    public ReturnBean deleteMenu(int menuId){
        boolean delete=menuService.deleteMenu(menuId);
        if (delete) {
            return super.success(null);
        } else {
            return super.fail(null);
        }
    }

    @RequestMapping("/findParentNameId")
    public ReturnBean findParentNameId(int menuId){
        Menu menu=menuService.findParentNameId(menuId);
        if (menu!=null){
            return super.success(menu);
        }else {
            return super.success(menuService.findMenuById(menuId));
        }
    }
    @RequestMapping("/updateMenu")
    public ReturnBean updateMenu(@RequestBody Menu menu){
        menu.setUpdateTime(new Date());
        boolean update = menuService.updateMenu(menu);
        if (update) {
            return super.success(null);
        } else {
            return super.fail(null);
        }
    }

}

