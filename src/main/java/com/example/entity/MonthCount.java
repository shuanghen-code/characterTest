package com.example.entity;

import lombok.Data;

/**
 * 统计每月测试人数的实体类
 */
@Data
public class MonthCount {
    // 每月测试的人数
    private int num;
    // 对应的月
    private String mydate;

}
