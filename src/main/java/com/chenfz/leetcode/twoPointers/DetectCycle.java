/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: DetectCycle
 * Author:   Chen FZ
 * Date:     2021/2/4 17:01
 * Description: 142. 环形链表 II
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.twoPointers;

import com.chenfz.leetcode.dataStructure.ListNode;

/**
 * 〈一句话功能简述〉<br>
 * 〈142. 环形链表 II〉
 *
 * @author Chen FZ
 * @create 2021/2/4
 * @since 1.0.0
 */
public class DetectCycle {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(-4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode1;
        ListNode res = detectCycle(listNode);
        System.out.println(res);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            //没有循环
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
