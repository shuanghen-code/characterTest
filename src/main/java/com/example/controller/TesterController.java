package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.*;
import com.example.service.ResultService;
import com.example.service.TesterService;
import com.example.util.Constants;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @Resource
    private ResultService resultService;


    /**
     * 查询所有测试人员的测试结果，包括分页、对应哪种颜色的性格
     * update by hxh
     * @param page 当前的页数
     * @param limit 每页多少条数据
     * @param tester 测试人信息
     * @return 所有数据
     */
    @RequestMapping("selectAllColor")
    public ReturnBean selectAllColor(Long page, Long limit, Tester tester) {
        //优化代码，不分页的时候，默认第一页，一页显示10条
        if (page == null) {
            page = Constants.page;
            limit = Constants.limit;
        }
        List<TesterVo> testerVos = testerService.selectAllColor(page, limit, tester);
        return super.success(testerVos, testerService.getCount(tester));
    }

    /**
     * 查询四种性格各自的总数
     * @return
     */
    @RequestMapping("selectAllCharacter")
    public ReturnBean selectAllCharacter() {
        TesterVo testerVo = testerService.selectAllCharacter();
        return super.success(testerVo);
    }

    /**
     * 统计每月参加测试的人数
     * @return
     */
    @RequestMapping("selectNumByMonth")
    public ReturnBean selectNumByMonth() {
        List<MonthCount> monthCounts = testerService.selectNumByMonth();
        return super.success(monthCounts);
    }


    /**
     * 使用mybatisplus自动生成的代码实现分页查询所有数据
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
            // 批量删除结果表中对应的测试记录
            for (Long testerId : idList) {
                QueryWrapper<Result> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("tester_id", testerId);
                resultService.remove(queryWrapper);
            }
            return super.success(null);
        } else {
            return super.fail(null);
        }
    }

}

