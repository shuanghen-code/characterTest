package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.User;
import com.example.entity.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息表(User)表服务接口
 *
 * @author makejava
 * @since 2021-12-02 18:36:55
 */
public interface UserService extends IService<User> {

    /**
     * 查询所有User，包括分页、
     * @param page 当前的页数
     * @param limit 每页多少条数据
     * @param user 信息
     * @return
     */
    List<UserVo> selectAllUserVo(@Param("page") Long page  , @Param("limit") Long limit, @Param("user") User user);

    /**
     * 获取user的数量
     * @param user
     * @return
     */
    Long getCount(@Param("user")User user);

    boolean updateUserAndSalt(User user);

    boolean saveUserAndSalt(User user);

    boolean resetPassword(User user);

    boolean updateRoleUser(User user, String roleIds);

}

