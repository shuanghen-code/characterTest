package com.example.entity;

import lombok.Data;

import java.util.List;

/**
 * 定义layui的树形菜单
 * @author wang hao
 * @date 2021/12/3 20:18
 */
@Data
public class LayUiTree {
    // 节点标题
    private String title;
    // 节点唯一索引值，用于对制定和节点进行操作
    private int id;
    // 节点是否初始为选中状态，默认false
    private boolean checked;
    // 节点是否初始展开，默认false
    private boolean spread;
    // 点击节点弹出的新弹窗对应的url。需要开启isJump参数
    private String url;
    // 子节点
    private List<LayUiTree> children;
    // 节点是否为禁用状态，默认false
    private boolean disabled;
}
