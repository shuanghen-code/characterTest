package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.ReturnBean;
import com.example.entity.Tester;
import com.example.service.TesterService;
import com.example.util.Constants;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (Tester)表控制层
 *
 * @author makejava
 * @since 2021-11-26 17:27:49
 */
@RestController
@RequestMapping("tester")
public class TesterController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private TesterService testerService;

    /**
     * 分页查询所有数据
     * update by hxh
     * @param page 分页对象
     * @param tester 查询实体
     * @return 所有数据
     */
    @RequestMapping("selectAll")
    public ReturnBean selectAll(Long page, Long limit, Tester tester) {
        //重新构建分页对象
        if(page==null){
            page= Constants.page;
            limit=Constants.limit;
        }
        Page<Tester> pageObj = new Page<>(page, limit);
        //条件查询对象
        QueryWrapper<Tester> testerQueryWrapper = new QueryWrapper<>();
        if(ObjectUtil.isNotEmpty(tester.getTesterName())){
            testerQueryWrapper.like("tester_name",tester.getTesterName());
        }
        if(ObjectUtil.isNotEmpty(tester.getPhonenum())){
            testerQueryWrapper.like("phonenum",tester.getPhonenum());
        }
        Page<Tester> testerPage = this.testerService.page(pageObj, testerQueryWrapper);

        return super.success(testerPage.getRecords(), testerPage.getTotal());
    }

    /**
     * 通过主键查询单条数据
     * update by hxh
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping()
    public ReturnBean selectOne(@PathVariable Serializable id) {
        Tester tester = this.testerService.getById(id);
        return success(tester);
    }

    /**
     * 通过手机号查询单条数据
     * update by hxh
     * @param
     * @return
     */
    @RequestMapping("/IfNumber")
    @ResponseBody
    public boolean selectByNumber(@RequestBody Tester tester){
        //Tester tester = this.testerService.getByPhonenum(phonenum);
        String phonenum = tester.getPhonenum();
        //根据用户名查询管理员（包括status为0的，以防恢复引起bug）
        //Tester tester1 = testerService.query(phonenum);
        if (tester == null){
            return true;//为true 则为没有该手机号
        }else {
            return false;
        }
    }


    /**
     * 新增数据
     * update by hxh
     * @param tester 实体对象
     * @return 新增结果
     */
    @PostMapping("insert")
    public ReturnBean insert(Tester tester, HttpSession session) {
        QueryWrapper<Tester> wrapper = new QueryWrapper<>();
        wrapper.eq("phonenum",tester.getPhonenum());
        List<Tester> list = this.testerService.list(wrapper);

        if(list.size()>0){
            return super.fail(tester);
        }else {
            tester.setTestTime(new Date());
            boolean save = this.testerService.save(tester);
            if(save){
                System.out.println(tester.toString());
//                Tester tester1 = this.testerService.query().eq("phonenum", tester.getPhonenum()).one();
                session.setAttribute("tester", tester);
                return super.success(tester);
            }else {
                return super.fail(tester);
            }
        }

    }

    /**
     * 修改数据
     *
     * @param tester 实体对象
     * @return 修改结果
     */
    @PostMapping("update")
    public ReturnBean update(@RequestBody Tester tester) {
        boolean update = this.testerService.updateById(tester);
        if (update){
            return super.success(tester);
        } else {
            return super.fail(tester);
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
        boolean delete = this.testerService.removeByIds(idList);
        if (delete){
            return super.success(null);
        } else {
            return super.fail(null);
        }
    }
}

