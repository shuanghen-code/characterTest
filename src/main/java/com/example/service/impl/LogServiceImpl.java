package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.LogDao;
import com.example.entity.Log;
import com.example.service.LogService;
import org.springframework.stereotype.Service;

/**
 * (Log)表服务实现类
 *
 * @author makejava
 * @since 2021-12-07 16:03:44
 */
@Service("logService")
public class LogServiceImpl extends ServiceImpl<LogDao, Log> implements LogService {

}

