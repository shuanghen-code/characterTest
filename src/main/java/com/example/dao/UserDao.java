package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;
import com.example.entity.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户信息表(User)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-02 18:36:55
 */
public interface UserDao extends BaseMapper<User> {
    /**
     * 查询所有用户user，包括分页、对应部门、角色
     * @param page 当前的页数
     * @param limit 每页多少条数据
     * @param user 测试人信息
     * @return
     */
    List<UserVo> selectAllUserVo(@Param("page") Long page  , @Param("limit") Long limit, @Param("user") User user);

    /**
     * 获取user的数量
     * @param user
     * @return
     */
    Long getCount(@Param("user")User user);

    /**
     * 重置密码
     * @param user
     * @return
     */
    Integer updatePassword(User user);
}

