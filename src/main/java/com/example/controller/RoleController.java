package com.example.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.ReturnBean;
import com.example.entity.Role;
import com.example.service.RoleService;
import com.example.util.Constants;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
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
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
//    @GetMapping("{id}")
//    public ReturnBean selectOne(@PathVariable Serializable id) {
//        return success(this.roleService.getById(id));
//    }

    /**
     * 新增数据
     *
     * @param role 实体对象
     * @return 新增结果
     */
//    @PostMapping
//    public ReturnBean insert(@RequestBody Role role) {
//        return success(this.roleService.save(role));
//    }

    /**
     * 修改数据
     *
     * @param role 实体对象
     * @return 修改结果
     */
//    @PutMapping
//    public ReturnBean update(@RequestBody Role role) {
//        return success(this.roleService.updateById(role));
//    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    /*@DeleteMapping
    public ReturnBean delete(@RequestParam("idList") List<Long> idList) {
        return success(this.roleService.removeByIds(idList));
    }*/
}

