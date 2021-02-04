/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: ListNode
 * Author:   Chen FZ
 * Date:     2021/2/4 17:03
 * Description: Definition for singly-linked list.
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.Leetcode.dataStructure;

/**
 * 〈一句话功能简述〉<br>
 * 〈Definition for singly-linked list.〉
 *
 * @author Chen FZ
 * @create 2021/2/4
 * @since 1.0.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
