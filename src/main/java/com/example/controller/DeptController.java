package com.example.controller;



import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Dept;
import com.example.entity.ReturnBean;
import com.example.entity.User;
import com.example.service.DeptService;
import com.example.util.Constants;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 部门表(Dept)表控制层
 *
 * @author makejava
 * @since 2021-12-02 18:25:30
 */
@RestController
@RequestMapping("dept")
public class DeptController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private DeptService deptService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param dept 查询实体
     * @return 所有数据
     */
    @GetMapping("/selectAll")
    public ReturnBean selectAll(Long page, Long limit, Dept dept) {
        //优化代码，不分页的时候，默认是第一页，一页显示10条
        if (page == null){
            page = Constants.page;
            limit = Constants.limit;
        }
        //构建分页对象，设置分页属性
        Page<Dept> pageObj = new Page<>(page, limit);

        //构造条件查询对象
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();

        //根据部门名称查询
        if (ObjectUtil.isNotEmpty(dept.getDeptName())){
            queryWrapper.like("dept_name", dept.getDeptName());
        }
        //根据创建人查询
        if (ObjectUtil.isNotEmpty(dept.getCreateBy())){
            queryWrapper.like("create_by", dept.getCreateBy());
        }
        //根据修改人查询
        if (ObjectUtil.isNotEmpty(dept.getUpdateBy())){
            queryWrapper.like("update_by", dept.getUpdateBy());
        }

        Page<Dept> deptPage = this.deptService.page(pageObj, queryWrapper);
        return super.success(deptPage.getRecords(), deptPage.getTotal());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ReturnBean selectOne(@PathVariable Serializable id) {
        return success(this.deptService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param dept 实体对象
     * @return 新增结果
     */
    @PostMapping("insert")
    public ReturnBean insert(@RequestBody Dept dept, HttpSession session) {
        User user = (User) session.getAttribute("user");
        dept.setCreateTime(new Date());
        dept.setCreateBy(user.getUserName());
        boolean save = this.deptService.save(dept);
        if (save){
            return super.success(dept);
        }else {
            return super.fail(dept);
        }
    }

    /**
     *@Description：根据部门id修改部门
     *@Param：[dept] 从前端传入的dept
     *@Return：com.example.entity.ReturnBean
     *@Author：wangLongFei
     *@Date：2021/12/6
     */
    @PostMapping("update")
    public ReturnBean update(@RequestBody Dept dept, HttpSession session) {
        User user = (User) session.getAttribute("user");
        dept.setUpdateTime(new Date());
        dept.setUpdateBy(user.getUserName());
        //根据后台的状态修改数据库
        if (dept.getStatus()==null || dept.getStatus() != 0){
            dept.setStatus(1);
        }
        boolean update = this.deptService.updateById(dept);
        if (update){
            return super.success(dept);
        }else {
            return super.fail(dept);
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
        boolean delete = deptService.removeByIds(idList);
        if (delete){
            return super.success(null);
        } else {
            return super.fail(null);
        }
    }


}

