package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.QuestionDao;
import com.example.entity.Question;
import com.example.service.QuestionService;
import org.springframework.stereotype.Service;

/**
 * 问题表(Question)表服务实现类
 *
 * @author makejava
 * @since 2021-11-26 17:25:54
 */
@Service("questionService")
public class QuestionServiceImpl extends ServiceImpl<QuestionDao, Question> implements QuestionService {

}

