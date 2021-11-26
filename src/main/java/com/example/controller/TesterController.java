package com.example.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Tester;
import com.example.service.TesterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Tester)表控制层
 *
 * @author makejava
 * @since 2021-11-26 17:27:49
 */
@RestController
@RequestMapping("tester")
public class TesterController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TesterService testerService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tester 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Tester> page, Tester tester) {
        return success(this.testerService.page(page, new QueryWrapper<>(tester)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.testerService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tester 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Tester tester) {
        return success(this.testerService.save(tester));
    }

    /**
     * 修改数据
     *
     * @param tester 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Tester tester) {
        return success(this.testerService.updateById(tester));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.testerService.removeByIds(idList));
    }
}

