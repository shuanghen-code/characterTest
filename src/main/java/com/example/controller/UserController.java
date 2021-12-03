package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.UserDao;
import com.example.entity.Menu;
import com.example.entity.ReturnBean;
import com.example.entity.User;
import com.example.service.MenuService;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息表(User)表控制层
 *
 * @author makejava
 * @since 2021-12-02 18:36:55
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    @Resource
    private MenuService menuService;

    /**
     * 管理员登录验证
     *
     * @return
     */
    @PostMapping("managerLogin")
    public ReturnBean managerLogin(@RequestBody User user) {
        List<User> userList = userService.findUserByLoginnameAndPassword(user);
        if (userList != null && userList.size() > 0) {
            return success(userList.get(0));
        } else {
            return fail(userList.get(0));
        }
    }

    @RequestMapping("managerMenu")
    public ModelAndView managerMenu(String loginName, ModelAndView modelAndView) {
//        modelAndView.addObject("user", user);

        //根据用户名查询所有的一级菜单
        List<Menu> firstMenus = new ArrayList<>();
        //根据用户名查询所有的二级菜单
        List<Menu> secondMenus = new ArrayList<>();
        //根据登录名查询出来所有的菜单，存入到session中
        List<Menu> menus = menuService.findMenuByLoginUser(loginName);
        // 开始菜单分类
        for (Menu menu : menus) {
            String menuType = menu.getMenuType();
            if (menuType.equals("M")) {
                firstMenus.add(menu);
            } else if (menuType.equals("C")) {
                secondMenus.add(menu);
            }
        }
        System.out.println(firstMenus + "===================----------");
        System.out.println(secondMenus + "===================----------");
        modelAndView.addObject("firstMenus", firstMenus);
        modelAndView.addObject("secondMenus", secondMenus);
        modelAndView.setViewName("managerHome");
        return modelAndView;
    }

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
//    @GetMapping
//    public ReturnBean selectAll(Page<User> page, User user) {
//        return success(this.userService.page(page, new QueryWrapper<>(user)));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
//    @GetMapping("{id}")
//    public R selectOne(@PathVariable Serializable id) {
//        return success(this.userService.getById(id));
//    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
//    @PostMapping
//    public R insert(@RequestBody User user) {
//        return success(this.userService.save(user));
//    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
//    @PutMapping
//    public R update(@RequestBody User user) {
//        return success(this.userService.updateById(user));
//    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
//    @DeleteMapping
//    public R delete(@RequestParam("idList") List<Long> idList) {
//        return success(this.userService.removeByIds(idList));
//    }

}