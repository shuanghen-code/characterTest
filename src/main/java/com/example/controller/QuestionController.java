package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Question;
import com.example.entity.ReturnBean;
import com.example.service.QuestionService;
import com.example.util.Constants;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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

    @RequestMapping("/selectAllQuestion")
    public ReturnBean<List<Question>> selectAll(Long page, Long limit, Question question) {
        //重新构建分页对象
        if(page==null){
            page= Constants.page;
            limit=Constants.limit;
        }
        Page<Question> pageObj = new Page<>(page, limit);
        //问题条件查询对象
        QueryWrapper<Question> questionQueryWrapper = new QueryWrapper<>();
        if(ObjectUtil.isNotEmpty(question.getQuestion())){
            questionQueryWrapper.like("question",question.getQuestion());
        }
        if(ObjectUtil.isNotEmpty(question.getCreator())){
            questionQueryWrapper.like("creator",question.getCreator());
        }
        Page<Question> questionPage = this.questionService.page(pageObj, questionQueryWrapper);
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
        // 根据后台的状态修改数据库
        if (question.getStatus()==null || question.getStatus() != 0){
            question.setStatus(1);
        }
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

