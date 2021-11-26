package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.ResultDao;
import com.example.entity.Result;
import com.example.service.ResultService;
import org.springframework.stereotype.Service;

/**
 * (Result)表服务实现类
 *
 * @author makejava
 * @since 2021-11-26 17:27:32
 */
@Service("resultService")
public class ResultServiceImpl extends ServiceImpl<ResultDao, Result> implements ResultService {

}

