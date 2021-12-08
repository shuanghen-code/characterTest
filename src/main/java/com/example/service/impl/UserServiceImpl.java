package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.UserDao;
import com.example.dao.UserRoleDao;
import com.example.entity.User;
import com.example.entity.UserRole;
import com.example.entity.UserVo;
import com.example.service.UserService;
import com.example.shiro.ShiroUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    @Resource
    private UserRoleDao userRoleDao;


    @Override
    public List<UserVo> selectAllUserVo(Long page, Long limit, User user) {
        return userDao.selectAllUserVo(page, limit, user);
    }

    @Override
    public Long getCount(User user) {
        return userDao.getCount(user);
    }

    @Override
    public boolean saveUserAndSalt(User user) {
        //获取从页面传入的角色id,因为salt是在后台生成，所有由salt属性传入角色id的集合
        String roleIds = user.getSalt();
        //生成随机码作为salt
        String salt = UUID.randomUUID().toString();
        //获取明文密码
        String message = user.getPassword();
        //获取密文密码
        String encryption = ShiroUtil.encryptionBySalt(salt, message);
        //设置user的密码属性
        user.setPassword(encryption);
        //设置user对象的盐值属性
        user.setSalt(salt);
        //将用户保存到数据库
        Integer insert = userDao.insert(user);
        //如果插入成功，并且页面传入的角色id不为空
        return updateRoleUser(user,roleIds);
    }

   /* @Override
    public boolean updateUserAndSalt(User user) {
        String roleIds = user.getSalt();
        //将用户保存到数据库
        user.setSalt(null);
        Integer update = userDao.update(user);
        //如果插入成功，并且页面传入的角色id不为空
        if(update>0){
            boolean b = updateRoleUser(user, roleIds);
            if(b){
                return true;
            }
        }

        return false;
    }*/

    @Override
    public boolean resetPassword(User user) {
        //生成随机码作为salt
        String salt = UUID.randomUUID().toString();
        //获取明文密码
        String message = user.getPassword();
        //获取密文密码
        String encryption = ShiroUtil.encryptionBySalt(salt, message);
        //设置user的密码属性
        user.setPassword(encryption);
        //设置user对象的盐值属性
        user.setSalt(salt);
        //将用户保存到数据库
        Integer reset = userDao.updatePassword(user);
        if(reset>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserAndSalt(User user) {
        String roleIds = user.getSalt();
        //将用户保存到数据库
        user.setSalt(null);
        //boolean reset = resetPassword(user);
        Integer update = userDao.updateById(user);
        //如果插入成功，并且页面传入的角色id不为空
        if(update>0){
            //boolean b = updateRoleUser(user, roleIds);
            boolean b = updateRoleUser(user,roleIds);
            if(b){
                return true;
            }
        }

        return false;
    }

    /**
     * @create by:
     * @description: 更新用户和角色中间表
     * @create time:
     */
    public boolean updateRoleUser(User user, String roleIds) {
        //String roleIds = user.getSalt();
        if ( roleIds != null) {
            //删除此用户原有的角色
            userRoleDao.deleteById(user.getUserId());
            //添加此用户关联的新角色
            String[] strings = roleIds.split(",");
            for (String string : strings) {
                if (string != null && string != "") {
                    Integer roleID = Integer.parseInt(string);
                    UserRole userRole = new UserRole();
                    userRole.setUserId(user.getUserId());
                    userRole.setRoleId(roleID);
                    userRoleDao.insert(userRole);
                }
            }
            return true;
        }
        return false;
    }

}

