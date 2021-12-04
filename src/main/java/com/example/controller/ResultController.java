package com.example.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Result;
import com.example.entity.ReturnBean;
import com.example.entity.Tester;
import com.example.service.ResultService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    public ReturnBean addResults(@RequestBody Map<Integer, String> map, HttpSession session){
        Tester tester = (Tester) session.getAttribute("tester");
        System.out.println(tester.toString());
        // 设置resultList
        List<Result> resultList = new ArrayList<>();
        for (Integer key:map.keySet()) {
            Result result = new Result();
            result.setTesterId(tester.getTesterId());
            result.setQuestionId(key);
            result.setResult(map.get(key));

            resultList.add(result);
        }
        // 调用saveBatch方法批量插入
        this.resultService.saveBatch(resultList);
        return super.success(null);
    }
}

