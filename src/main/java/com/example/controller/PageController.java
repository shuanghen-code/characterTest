package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.entity.Menu;
import com.example.entity.Tester;
import com.example.entity.TesterVo;
import com.example.entity.User;
import com.example.service.MenuService;
import com.example.service.TesterService;
import com.example.service.UserService;
import com.example.util.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

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


    @Autowired
    private TesterService testerService;
    /**
     * @return testerLogin
     * @description 页面跳转__去用户登录页面
     * @Data 2021/11/27 13:01
     * @Version 1.0
     */
    @RequestMapping("test/toTesterLogin")
    public String toPage() {
        return "test/testerLogin";
    }

    // 去往答题页面
    @RequestMapping("test/toExam")
    public String toExam(HttpSession session){
        //若未登录，跳转到登录页面
        if (ObjectUtil.isNull(session.getAttribute("tester"))){
            return "redirect:/test/toTesterLogin";
        }
        return "test/exam";
    }

    // 去往测试完成页面
    @RequestMapping("test/toFinish")
    public ModelAndView toFinish(HttpSession session,ModelAndView modelAndView) {

        List<TesterVo> testerVos = testerService.selectAllColor(Constants.page,
                Constants.limit, new Tester());
        Tester tester=(Tester)session.getAttribute("tester");
        for (TesterVo t:testerVos) {
            if (t.getTesterId().equals(tester.getTesterId())){
                modelAndView.addObject("testerVO",t);
                if (t.getBlueCount()==null){
                    t.setBlueCount(0);
                }
                if (t.getGreenCount()==null){
                    t.setGreenCount(0);
                }
                if (t.getRedCount()==null){
                    t.setRedCount(0);
                }
                if (t.getYellowCount()==null){
                    t.setYellowCount(0);
                }
                Map countMap=new HashMap();
                countMap.put("redCount",t.getRedCount());
                countMap.put("blueCount",t.getBlueCount());
                countMap.put("yellowCount",t.getYellowCount());
                countMap.put("greenCount",t.getGreenCount());
                String maxKey = getMapMinOrMaxValueKey(countMap, "max");
                modelAndView.addObject("maxCount",maxKey);
                session.removeAttribute("tester");
            }
        }
        modelAndView.setViewName("test/finish");
        return modelAndView;
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
    @RequestMapping("manager/toManagerHome")
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
            String menuType = String.valueOf(menu.getMenuType());
            if (menuType.equals("M")) {
                firstMenus.add(menu);
            } else if (menuType.equals("C")) {
                secondMenus.add(menu);
            }
        }
        modelAndView.addObject("firstMenus", firstMenus);
        modelAndView.addObject("secondMenus", secondMenus);
        modelAndView.setViewName("manager/managerHome");
        return modelAndView;
    }

    @RequestMapping("manager/toIndex")
    public String toIndex(){

        return "manager/index";
    }

    // 去往问题管理页面
    @RequestMapping("manager/toquestionManager")
    public String toTest() {
        return "manager/questionManager";
    }

    // 去往测试结果管理页面
    @RequestMapping("manager/toTester")
    public String toTester(){
        return "manager/testerManager";
    }

    //去往用户管理页面
    @RequestMapping("manager/toUser")
    public String toUserManager(){
        return "manager/userManager";
    }

    // 去往角色管理页面
    @RequestMapping("manager/toRole")
    public String toRoleManager(){
        return "manager/roleManager";
    }

    //去往部门管理页面
    @RequestMapping("manager/toDept")
    public String toDeptManager(){
        return "manager/deptManager";
    }

    // 去菜单管理页面
    @RequestMapping("manager/toMenu")
    public String toMenu(){
        return "manager/treeTable";
    }

    //去日志管理页面
    @RequestMapping("manager/toLog")
    public String toLog(){
        return "manager/logManager";
    }
    /**
     *  注销
     */
    @RequestMapping("manager/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    /**
     * 去未授权页面
     * @return
     */
    @RequestMapping("/toUnau")
    public String toUnau(){
        return "unau";
    }
    public static String getMapMinOrMaxValueKey(Map<String, Double> map, String choose) {
        List<Map.Entry<String,Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o1.getValue().intValue() - o2.getValue().intValue()));
        String key = "";
        if (choose.equals("min")) {
            key = list.get(0).getKey();
        } else if (choose.equals("max")) {
            key = list.get(list.size() - 1).getKey();
        }
        return key;
    }
}
