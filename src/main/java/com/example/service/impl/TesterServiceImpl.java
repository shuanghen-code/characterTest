package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.TesterDao;
import com.example.entity.Tester;
import com.example.service.TesterService;
import org.springframework.stereotype.Service;

/**
 * (Tester)表服务实现类
 *
 * @author makejava
 * @since 2021-11-26 17:27:49
 */
@Service("testerService")
public class TesterServiceImpl extends ServiceImpl<TesterDao, Tester> implements TesterService {

}

