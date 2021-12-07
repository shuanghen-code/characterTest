package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.DeptDao;
import com.example.entity.Dept;
import com.example.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门表(Dept)表服务实现类
 *
 * @author makejava
 * @since 2021-12-06 16:46:31
 */
@Service("deptService")
public class DeptServiceImpl extends ServiceImpl<DeptDao, Dept> implements DeptService {
    @Resource
    private DeptDao deptDao;

    @Override
    public List<Dept> queryAll(Dept dept) {
        return deptDao.queryAll(dept);
    }


}

