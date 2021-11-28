package com.example.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Question;
import com.example.entity.ReturnBean;
import com.example.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 问题表(Question)表控制层
 *
 * @author makejava
 * @since 2021-11-26 17:26:30
 */

@RestController
@RequestMapping("question")
public class QuestionController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private QuestionService questionService;

    /**
     * 分页查询所有数据
     * @return 所有数据
     */
   /* @GetMapping("selectAllQuestion")
    public ReturnBean selectAllQuestion(long page, long limit, Question question) {
        System.out.println("page:"+page+", limit:"+limit);
        Page<Question> page1 = new Page<>(page, limit);
        Page<Question> questionPage = this.questionService.page(page1, new QueryWrapper<>(question));
        return super.success(questionPage.getRecords(), questionPage.getTotal());
    }*/

    @GetMapping("selectAllQuestion")
    public ReturnBean selectAll(Long page, Long limit, Question question) {
        //重新构建分页对象
        Page<Question> pageObj = new Page<>(page, limit);
        Page<Question> questionPage = this.questionService.page(pageObj, new QueryWrapper<>(question));
        return super.success(questionPage.getRecords(),questionPage.getTotal());
    }


    /**
     * exam答题界面查询的问题列表
     * @return
     */
    @GetMapping("queryAllQuestion")
    public ReturnBean queryAllQuestion() {
        //重新构建分页对象
        List<Question> question = questionService.list();
        return super.success(question);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ReturnBean selectOne(@PathVariable Serializable id) {
        return success(this.questionService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param question 实体对象
     * @return 新增结果
     */
    @PostMapping("insert")
    public ReturnBean insert(@RequestBody Question question) {
        question.setCreateTime(new Date());
        boolean save = this.questionService.save(question);
        if (save){
            return super.success(question);
        } else {
            return super.fail(question);
        }
    }

    /**
     * 修改数据
     *
     * @param question 实体对象
     * @return 修改结果
     */
    @PostMapping("update")
    public ReturnBean update(@RequestBody Question question) {
        question.setUpdateTime(new Date());
        boolean update = this.questionService.updateById(question);
        if (update){
            return super.success(question);
        } else {
            return super.fail(question);
        }
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @RequestMapping("delete")
    public ReturnBean delete(@RequestParam(value = "idList[]", required = false) List<Long> idList) {
        boolean delete = this.questionService.removeByIds(idList);
        if (delete){
            return super.success(null);
        } else {
            return super.fail(null);
        }
    }
}

