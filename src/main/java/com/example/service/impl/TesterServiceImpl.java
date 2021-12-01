package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.TesterDao;
import com.example.entity.Tester;
import com.example.entity.TesterVo;
import com.example.service.TesterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Tester)表服务实现类
 *
 * @author makejava
 * @since 2021-11-26 17:27:49
 */
@Service("testerService")
public class TesterServiceImpl extends ServiceImpl<TesterDao, Tester> implements TesterService {
    @Resource
    private TesterDao testerDao;

    @Override
    public List<TesterVo> selectAllColor(Long page, Long limit, Tester tester) {
        return testerDao.selectAllColor(page, limit, tester);
    }

    @Override
    public Long getCount(Tester tester) {
        return testerDao.getCount(tester);
    }
}

