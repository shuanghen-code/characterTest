package com.example.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Menu;
import com.example.service.MenuService;
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
public class MenuController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param menu 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Menu> page, Menu menu) {
        return success(this.menuService.page(page, new QueryWrapper<>(menu)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.menuService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param menu 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Menu menu) {
        return success(this.menuService.save(menu));
    }

    /**
     * 修改数据
     *
     * @param menu 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Menu menu) {
        return success(this.menuService.updateById(menu));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.menuService.removeByIds(idList));
    }
}

