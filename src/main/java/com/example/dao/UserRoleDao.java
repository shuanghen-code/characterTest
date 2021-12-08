package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户和角色关联表(UserRole)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-07 15:03:19
 */

public interface UserRoleDao extends BaseMapper<UserRole> {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    UserRole queryById(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userRole 实例对象
     * @return 对象列表
     */
    List<UserRole> queryAll(UserRole userRole);

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 影响行数
     */
    int insert(UserRole userRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserRole> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UserRole> entities);

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 影响行数
     */
    int update(UserRole userRole);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Integer userId);
    int deleteByRoleId(Integer roleId);


    List<Integer> findMenuIdsByRoleId(Integer roleId);


    List<UserRole> queryByUserId(Integer userId);


}

