package com.example.controller;


import cn.hutool.core.util.ReflectUtil;
import com.example.entity.*;
import com.example.service.*;
import com.example.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 用户信息表(User)表控制层
 *
 * @author makejava
 * @since 2021-12-02 18:36:55
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    @Resource
    private MenuService menuService;
    @Autowired
    DeptService deptService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserRoleService userRoleService;


    /**
     * 管理员登录验证
     *
     * @return
     */
    @PostMapping("managerLogin")
    public ReturnBean managerLogin(@RequestBody User user, HttpSession session) {
        // 获取shiro主体，subject
        Subject subject = SecurityUtils.getSubject();
        // 构建用户登陆的令牌
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());
        // 登录操作
        try {
            subject.login(token);
        } catch (UnknownAccountException u) {
            return super.fail(user, "用户名不存在");
        } catch (IncorrectCredentialsException ie) {
            return super.fail(user, "密码不正确");
        }

        // 获取Myrealm里SimpleAuthenticationInfo存入的user对象
        Object principal = subject.getPrincipal();
        session.setAttribute("user", principal);
        return success(principal);
    }

    /**
     * 分页查询所有数据
     * update by hxh
     *
     * @return 所有数据
     */
    @GetMapping("findAll")
    public ReturnBean<List<User>> selectAll(Long page, Long limit, User user) {
        log.info("================找到user====================");

        //优化代码，不分页的时候，默认第一页，一页显示10条
        if (page == null) {
            page = Constants.page;
            limit = Constants.limit;
        }

        //登录名查询对象
        List<UserVo> userVos = userService.selectAllUserVo(page, limit, user);
        return super.success(userVos, userService.getCount(user));


    }


    /**
     * 填充部门下拉框，查询部门信息
     * update by hxh
     *
     * @param
     * @param
     * @return 部门信息列表
     */
    @GetMapping("findAllDept")
    public List<Dept> selectAll() {
        //查询所有的部门信息，填充到页面下拉框中
        log.info("===========查询部门信息============");

        List<Dept> deptList = deptService.queryAll(null);

        return deptList;

    }

    /**
     * 填充部门下拉框，查询部门信息
     * update by hxh
     *
     * @param
     * @param
     * @return 部门信息列表
     */
    @GetMapping("findAllRole")
    public List<Role> selectAllRole() {
        //查询所有的部门信息，填充到页面下拉框中
        log.info("===========查询角色信息============");

        List<Role> roleList = roleService.list(null);

        return roleList;

    }


    /**
     * 通过userId 查询角色信息
     *
     * @param userId
     * @return 角色list
     */
    @GetMapping("/findSelectRole")
    public ReturnBean finSelectRole(Integer userId) {
        List<UserRole> userRole = userRoleService.queryByUserId(userId);
        return success(userRole);
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @RequestMapping("/insertUser")
    public ReturnBean insert(@RequestBody User user) {
        log.info("====================新增用户======================");
        user = setCreate(user);
        user.setFlag("0");
        boolean insert = userService.saveUserAndSalt(user);
        if (insert) {
            return success(null);
        }
        return fail(null);
    }

    /**
     * 删除数据(逻辑删除)
     *
     * @return 删除结果
     */
    @RequestMapping("/deleteById")
    public ReturnBean delete(@RequestBody User user) {
        log.info("==============进入行删除==============");
        //修改人，修改时间
        user = setUpdate(user);
        boolean update = userService.updateById(user);
        if (update) {
            boolean delete = userService.removeById(user.getUserId());
            if(delete){
                return success(null);
            }
            return fail(null);
        }
        return fail(null);

    }


    /**
     * 批量删除数据(逻辑删除)
     *
     * @return 删除结果
     */
    @RequestMapping("/delSelected")
    public ReturnBean deleteByBatch(@RequestBody List<User> userList) {
        log.info("==============进入行删除==============");
        List<Integer> userIdList = new ArrayList<>();
        //修改人，修改时间
        for (User user : userList) {
            user = setUpdate(user);
            userIdList.add(user.getUserId());
        }
        boolean update = userService.saveOrUpdateBatch(userList);
        if (update) {
            boolean delete = userService.removeByIds(userIdList);
            if(delete){
                return success(null);
            }else {
                return fail(null);
            }
        }
        return fail(null);

    }


    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @PostMapping("/updateUser")
    public ReturnBean update(@RequestBody User user) {
        log.info("===========修改==========");
        user = setUpdate(user);
        //boolean update = userService.updateById(user);
        boolean update = userService.updateUserAndSalt(user);
        if (update) {
            //boolean updateRoleUser = userService.updateRoleUser(user);
            return success(null);
        }
        return fail(null);
    }

    /**
     * 重置密码
     */
    @RequestMapping("updatePassword")
    public ReturnBean updatePassword(User user) {
        user = setUpdate(user);
        boolean update = userService.resetPassword(user);
        if (update) {
            return success(null);
        }
        return fail(null);

    }


    /**
     * @return
     * @create by: hxh
     * @description: 统一处理创建人，创建时间
     */
    public <T> T setCreate(T t) {
        //shiro框架获取登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //hutool工具调用方法
        ReflectUtil.invoke(t, "setCreateBy", user.getUserName());
        ReflectUtil.invoke(t, "setCreateTime", new Date());
        return t;
    }

    /**
     * @return
     * @create by: hxh
     * @description: 统一处理修改人，修改时间
     */
    public <T> T setUpdate(T t) {
        //shiro框架获取登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //hutool工具调用方法
        ReflectUtil.invoke(t, "setUpdateBy", user.getUserName());
        ReflectUtil.invoke(t, "setUpdateTime", new Date());
        return t;
    }

}