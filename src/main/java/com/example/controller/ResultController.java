package com.example.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Result;
import com.example.service.ResultService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Result)表控制层
 *
 * @author makejava
 * @since 2021-11-26 17:27:32
 */
@RestController
@RequestMapping("result")
public class ResultController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ResultService resultService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param result 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Result> page, Result result) {
        return success(this.resultService.page(page, new QueryWrapper<>(result)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.resultService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param result 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Result result) {
        return success(this.resultService.save(result));
    }

    /**
     * 修改数据
     *
     * @param result 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Result result) {
        return success(this.resultService.updateById(result));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.resultService.removeByIds(idList));
    }
}

