package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Tester;
import com.example.entity.TesterVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Tester)表服务接口
 *
 * @author makejava
 * @since 2021-11-26 17:27:49
 */
public interface TesterService extends IService<Tester> {

    /**
     * 查询所有测试人员的测试结果，包括分页、对应哪种颜色的性格
     * @param page 当前的页数
     * @param limit 每页多少条数据
     * @param tester 测试人信息
     * @return
     */
    List<TesterVo> selectAllColor(@Param("page") Long page  , @Param("limit") Long limit, @Param("tester") Tester tester);

    /**
     * 获取参加测试人员的数量
     * @param tester
     * @return
     */
    Long getCount(@Param("tester")Tester tester);

}

