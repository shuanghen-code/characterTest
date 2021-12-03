package com.example.util;

import com.example.entity.LayUiTree;
import com.example.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wang hao
 * @date 2021/12/3 20:17
 */
public class TreeUtils {

    /**
     * 根据父节点id获取所有子节点
     * @param list
     * @param parentId
     * @return
     */
    public static List<LayUiTree> getChildPerms(List<Menu> list, int parentId){
        List<LayUiTree> treeList = new ArrayList<>();
        for (Menu menu : list) {
            // 根据传入的某个父节点的ID，遍历该父节点的所有子节点
            if (menu.getParentId() == parentId) {
                LayUiTree tree = fromMenuToTree(menu);
                // 递归，把当前菜单和所有菜单放入递归中，给当前的tree找孩子
                LayUiTree layUiTree = recursionFn(tree, list);
                treeList.add(layUiTree);
            }
        }
        return treeList;
    }

    /**
     * 递归调用，给每一个tree配上自己的孩子
     * @param layUiTree
     * @param list
     * @return
     */
    private static LayUiTree recursionFn(LayUiTree layUiTree, List<Menu> list) {
        List<LayUiTree> childNodes = new ArrayList<>();
        for (Menu node : list) {
            if (node.getParentId().equals(layUiTree.getId())) {
                LayUiTree tree = fromMenuToTree(node);
                childNodes.add(recursionFn(tree, list));
            }
        }
        layUiTree.setChildren(childNodes);
        return layUiTree;
    }

    /**
     * 将menu对象转换为layuitree对象
     */
    private static LayUiTree fromMenuToTree(Menu menu){
        LayUiTree tree = new LayUiTree();
        tree.setId(menu.getMenuId());
        tree.setTitle(menu.getMenuName());
        tree.setChecked(false);
        tree.setUrl(menu.getUrl());
        return tree;
    }
}
