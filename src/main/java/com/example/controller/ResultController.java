package com.example.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Result;
import com.example.entity.ReturnBean;
import com.example.service.ResultService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * (Result)表控制层
 *
 * @author makejava
 * @since 2021-11-26 17:27:32
 */
@RestController
@RequestMapping("result")
public class ResultController extends BaseController {
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
    public ReturnBean selectAll(Page<Result> page, Result result) {
        return success(this.resultService.page(page, new QueryWrapper<>(result)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
  /*  @GetMapping("{id}")
    public ReturnBean selectOne(@PathVariable Serializable id) {
        return success(this.resultService.getById(id));
    }
*/
    /**
     * 新增数据
     *
     * @param result 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ReturnBean insert(@RequestBody Result result) {
        return success(this.resultService.save(result));
    }

    /**
     * 修改数据
     *
     * @param result 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ReturnBean update(@RequestBody Result result) {
        return success(this.resultService.updateById(result));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ReturnBean delete(@RequestParam("idList") List<Long> idList) {
        return success(this.resultService.removeByIds(idList));
    }

    /**
     * 根据前台传过来的map，批量插入到tbl_character_result表中
     *
     */
//    @RequestMapping(value = "score", method = RequestMethod.POST)
    @PostMapping("addResults")
    public ReturnBean addResults(@RequestParam List<Map<Integer, String>> results){

        // 设置resultList

        // 调用saveBatch方法批量插入

        Result result = new Result();
        return super.success(null);
    }
}

