/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MergeTwoList
 * Author:   chenfz
 * Date:     2019/3/12 22:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.tree;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author chenfz
 * @create 2019/3/12
 * @since 1.0.0
 */
public class MergeTwoList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode h = null;
        if (l1.val > l2.val) {
            h = l2.next;
            ListNode node = mergeTwoLists(h, l1);
            l2.next = node;
            return l2;
        } else {
            h = l1.next;
            ListNode node = mergeTwoLists(h, l2);
            l1.next = node;
            return l1;
        }
    }
}
