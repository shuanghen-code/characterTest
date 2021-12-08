package com.example.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Dept;
import com.example.entity.Log;
import com.example.entity.ReturnBean;
import com.example.service.LogService;
import com.example.util.Constants;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Log)表控制层
 *
 * @author makejava
 * @since 2021-12-08 09:32:04
 */
@RestController
@RequestMapping("log")
public class LogController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private LogService logService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param log 查询实体
     * @return 所有数据
     */
    @GetMapping("selectAll")
    public ReturnBean selectAll(Long page, Long limit, Log  log) {
        //优化代码，不分页的时候，默认是第一页，一页显示10条
        if (page == null){
            page = Constants.page;
            limit = Constants.limit;
        }
        //构建分页对象，设置分页属性
        Page<Log> pageObj = new Page<>(page, limit);
        //条件查询对象
        QueryWrapper<Log> queryWrapper = new QueryWrapper<>();
        Page<Log> logPage = this.logService.page(pageObj, queryWrapper);
        return success(logPage.getRecords(),logPage.getTotal());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ReturnBean selectOne(@PathVariable Serializable id) {
        return success(this.logService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param log 实体对象
     * @return 新增结果
     */
    @PostMapping("insert")
    public ReturnBean insert(@RequestBody Log log) {
        return success(this.logService.save(log));
    }

    /**
     * 修改数据
     *
     * @param log 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public ReturnBean update(@RequestBody Log log) {
        return success(this.logService.updateById(log));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    public ReturnBean delete(@RequestParam("idList[]") List<Long> idList) {
        return success(this.logService.removeByIds(idList));
    }
}

