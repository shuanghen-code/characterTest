package com.example.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.*;
import com.example.service.MenuService;
import com.example.service.RoleMenuService;
import com.example.service.RoleService;
import com.example.util.Constants;
import com.example.util.TreeUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 角色信息表(Role)表控制层
 *
 * @author makejava
 * @since 2021-12-02 14:58:24
 */
@RestController
@RequestMapping("role")
public class RoleController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    @Resource
    private MenuService menuService;

    @Resource
    private RoleMenuService roleMenuService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param role 查询实体
     * @return 所有数据
     */
    @GetMapping("findAll")
    public ReturnBean selectAll(Long page, Long limit, Role role) {
        if (page==null) {
            page = Constants.page;
            limit = Constants.limit;
        }
        Page<Role> roleobj = new Page<>(page, limit);
        Page<Role> rolePage = this.roleService.page(roleobj, new QueryWrapper<>(role));

        return super.success(rolePage.getRecords(), rolePage.getTotal());
    }

    /**
     * 新增角色时，查询所有存在的菜单
     * @return List<LayUiTree>
     */
    @GetMapping("findAllMenu")
    public List<LayUiTree> findAllMenu(){
        List<Menu> menus = menuService.list();
        List<LayUiTree> treeList = TreeUtils.getChildPerms(menus, 0);
        if (treeList.size()>0){
            return treeList;
        } else {
            return null;
        }
    }


    /**
     * 新增角色之前，校验角色名称是否已存在
     * @return
     */
    @RequestMapping("checkRoleName")
    public ReturnBean checkRoleName(String roleName){
        // 校验角色名是否重复
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_name", roleName);
        List<Role> roles = roleService.list(queryWrapper);
        if (roles != null && roles.size()>0) {
            return fail(null, "角色名重复！");
        } else {
            return success(null);
        }
    }

    /**
     * 新增角色
     * @param roleData
     * @return
     */
    @RequestMapping("insertRole")
    public ReturnBean insertRole(RoleData roleData, HttpSession session){
        // 获取创建人信息
        User user = (User) session.getAttribute("user");

        Role role = new Role();
        role.setRoleName(roleData.getRoleName());
        role.setRoleKey(roleData.getRoleKey());
        role.setRoleSort(roleData.getRoleSort());
        role.setStatus(roleData.getStatus());
        role.setCreateBy(user.getUserName());
        role.setCreateTime(new Date());
        role.setRemark(roleData.getRemark());
        boolean save = roleService.save(role);
        if (save) {
            List<Integer> menus = roleData.getMenus();
            List<RoleMenu> roleMenus = new ArrayList<>();
            for (Integer menuId : menus) {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(role.getRoleId());
                roleMenu.setMenuId(menuId);
                roleMenus.add(roleMenu);
            }
            // 批量插入rolemenu表
            roleMenuService.saveBatch(roleMenus);
            return success(null);
        } else {
            return fail(null);
        }
    }

    /**
     * 修改角色时，查询所有存在的菜单
     * @return List<Integer> 菜单的id列表
     */
    @RequestMapping("findSelectMenu")
    public List<Integer> findSelectMenu(Integer roleId){
        // 1，查询当前角色对应的所有菜单id
        List<Integer> Ids = roleService.findMenuIdsByRoleId(roleId);
        // 2，如果一个菜单存在子菜单，必须把当前id从list中去掉，否则无法三级菜单无法半选
        List<Menu> menuList = menuService.listByIds(Ids);
        List<LayUiTree> menuTree = TreeUtils.getChildPerms(menuList, 0);
        List<Integer> menuIds = check(menuTree, new ArrayList<>());
        if (menuIds.size()>0){
            return menuIds;
        } else {
            return null;
        }
    }

    /**
     * 查找所有菜单，如果其不存在子菜单，将其添加到list中
     * @param menuTree
     * @return
     */
    private List<Integer> check(List<LayUiTree> menuTree, List<Integer> menuIdList){
        for (LayUiTree tree : menuTree) {
            if (tree.getChildren().isEmpty()) {
                menuIdList.add(tree.getId());
            } else {
                check(tree.getChildren(), menuIdList);
            }
        }
        return menuIdList;
    }


    /**
     * 修改角色
     *
     * @param roleData 实体对象
     * @return 修改结果
     */
    @PutMapping("updateRole")
    public ReturnBean updateRole(RoleData roleData, HttpSession session) {

        // 获取创建人信息
        User user = (User) session.getAttribute("user");

        Role role = new Role();
        role.setRoleId(roleData.getRoleId());
        role.setRoleName(roleData.getRoleName());
        role.setRoleKey(roleData.getRoleKey());
        role.setRoleSort(roleData.getRoleSort());
        role.setStatus(roleData.getStatus());
        role.setUpdateBy(user.getUserName());
        role.setUpdateTime(new Date());
        role.setRemark(roleData.getRemark());
        boolean update = roleService.updateById(role);
        if (update) {
            // 先将原来RoleMenu表中该用户对应的菜单删掉，再插入新的菜单。
            QueryWrapper<RoleMenu> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("role_id", role.getRoleId());
            boolean delete = roleMenuService.remove(queryWrapper);
            if (delete) {
                List<Integer> menus = roleData.getMenus();
                List<RoleMenu> roleMenus = new ArrayList<>();
                for (Integer menuId : menus) {
                    RoleMenu roleMenu = new RoleMenu();
                    roleMenu.setRoleId(role.getRoleId());
                    roleMenu.setMenuId(menuId);
                    roleMenus.add(roleMenu);
                }
                // 批量插入rolemenu表
                roleMenuService.saveBatch(roleMenus);
            }
            return success(null);
        } else {
            return fail(null);
        }
    }

    /**
     * 删除数据
     *
     * @param roleId 主键
     * @return 删除结果
     */
    @RequestMapping("deleteById")
    public ReturnBean deleteById(Integer roleId) {
        boolean delete = roleService.removeById(roleId);
        if (delete) {
            return success(null);
        } else {
            return fail(null);
        }
    }
}

