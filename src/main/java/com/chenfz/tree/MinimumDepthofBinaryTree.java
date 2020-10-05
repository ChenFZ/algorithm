/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MinimumDepthofBinaryTree
 * Author:   chenfz
 * Date:     2019/3/12 18:57
 * Description: 二叉树的最小深度
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.tree;


/**
 * 〈一句话功能简述〉<br> 
 * 〈二叉树的最小深度〉
 *
 * @author chenfz
 * @create 2019/3/12
 * @since 1.0.0
 */
public class MinimumDepthofBinaryTree {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ll";
    }
    private static int minDepth(TreeNode root){
        if(root == null) return 0;
        if(root.right == null) return minDepth(root.left)+1;
        if(root.left == null) return minDepth(root.right)+1;
        return 1+Math.min(minDepth(root.right),minDepth(root.left));
    }
    private static int maxDepth(TreeNode root){
        if(root == null) return 0;
        return 1+Math.max(maxDepth(root.right),maxDepth(root.left));
    }
}
