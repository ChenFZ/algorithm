/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IsBalance
 * Author:   chenfz
 * Date:     2019/3/12 19:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.tree;

/**
 * 〈一句话功能简述〉<br> 
 * 〈给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。〉
 *
 * @author chenfz
 * @create 2019/3/12
 * @since 1.0.0
 */
public class IsBalance {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>1) return false;
        else{
            if(isBalanced(root.left) && isBalanced(root.right))
                return true;
            else
                return false;
        }
    }

    private static int maxDepth(TreeNode root){
        if(root == null) return 0;
        return 1+Math.max(maxDepth(root.right),maxDepth(root.left));
    }
}
