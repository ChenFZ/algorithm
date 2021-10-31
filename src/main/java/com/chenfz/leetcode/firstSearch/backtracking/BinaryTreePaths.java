/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: BinaryTreePaths
 * Author:   chenfz
 * Date:     2021/8/19 11:22
 * Description: Binary Tree Paths (Easy）
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.firstSearch.backtracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈Binary Tree Paths (Easy)〉
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明:叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * @author chenfz
 * @create 2021/8/19
 * @since 1.0.0
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, null, new TreeNode(5));
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        List<String> strings = binaryTreePaths.binaryTreePaths(root);
        System.out.println(Arrays.toString(strings.toArray()));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<List<TreeNode>> res = new ArrayList<>();
        Queue<TreeNode> path = new LinkedList<>();
        bt(root, path, res);
        List<String> collect = res.stream().map(nodeList -> listToString(nodeList)).collect(Collectors.toList());
        return collect;
    }

    private String listToString(List<TreeNode> nodeList) {
        StringBuffer buffer = new StringBuffer();
        for (TreeNode treeNode : nodeList) {
            buffer.append(treeNode.val);
            buffer.append("->");
        }
        if (buffer.length() > 0) {
            buffer.delete(buffer.length() - 2, buffer.length());
        }
        return buffer.toString();
    }

    private boolean bt(TreeNode root, Queue<TreeNode> path, List<List<TreeNode>> res) {
        if (root != null) {
            path.add(root);
            boolean left = bt(root.left, path, res);
            boolean right = bt(root.right, path, res);
            if (!left && !right) {
                res.add(new ArrayList<>(path));
            }
            path.remove(root);
            return true;
        }
        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
