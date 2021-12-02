package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息表(User)表服务实现类
 *
 * @author makejava
 * @since 2021-12-02 18:36:55
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<User> findUserByLoginnameAndPassword(User user) {
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("login_name", user.getLoginName());
        conditions.put("password", user.getPassword());
        return userDao.selectByMap(conditions);
    }
}

