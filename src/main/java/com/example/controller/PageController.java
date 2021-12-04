package com.example.controller;

import com.example.entity.Menu;
import com.example.entity.User;
import com.example.service.MenuService;
import com.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wang hao
 * @date 2021/11/28 10:38
 */
@Controller
public class PageController {

    @Resource
    private UserService userService;

    @Resource
    private MenuService menuService;

    /**
     * @return testerLogin
     * @description 页面跳转__去用户登录页面
     * @Data 2021/11/27 13:01
     * @Version 1.0
     */
    @RequestMapping("toTesterLogin")
    public String toPage() {
        return "testerLogin";
    }

    // 去往答题页面
    @RequestMapping("toExam")
    public String toExam(){
        return "exam";
    }

    // 去往测试完成页面
    @RequestMapping("tofinish")
    public String toFinish(HttpSession session) {
        session.removeAttribute("tester");
        return "finish";
    }

    /**
     * @return login
     * @description 页面跳转__去管理员登录页面
     * @Data 2021/11/27 13:01
     * @Version 1.0
     */
    @RequestMapping("toMlogin")
    public String toMlogin(){
        return "login";
    }

    // 去往管理后台首页
    @RequestMapping("toManagerHome")
    public ModelAndView toManagerHome(Integer userId, ModelAndView modelAndView) {
        // 根据userId查询用户信息
        User user = userService.getById(userId);
        modelAndView.addObject("user", user);

        //根据用户名查询所有的一级菜单
        List<Menu> firstMenus = new ArrayList<>();
        //根据用户名查询所有的二级菜单
        List<Menu> secondMenus = new ArrayList<>();
        //根据登录名查询出来所有的菜单，存入到session中
        List<Menu> menus = menuService.findMenuByLoginUser(user.getLoginName());
        // 开始菜单分类
        for (Menu menu : menus) {
            String menuType = menu.getMenuType();
            if (menuType.equals("M")) {
                firstMenus.add(menu);
            } else if (menuType.equals("C")) {
                secondMenus.add(menu);
            }
        }
//        System.out.println(firstMenus + "===================----------");
//        System.out.println(secondMenus + "===================----------");
        modelAndView.addObject("firstMenus", firstMenus);
        modelAndView.addObject("secondMenus", secondMenus);
        modelAndView.setViewName("managerHome");
        return modelAndView;
    }

    // 去往问题管理页面
    @RequestMapping("toquestionManager")
    public String toTest() {
        return "questionManager";
    }

    // 去往测试结果管理页面
    @RequestMapping("toTester")
    public String toTester(){
        return "testerManager";
    }

    // 去往角色管理页面
    @RequestMapping("toRoleManager")
    public String toRoleManager(){
        return "roleManager";
    }


    /**
     *  注销
     */
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping("/toUnau")
    public String toUnau(){
        System.out.println("没有权限！！！！");
        return "unau";
    }
}
