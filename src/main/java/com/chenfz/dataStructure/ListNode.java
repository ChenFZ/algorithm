/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ListNode
 * Author:   chenfz
 * Date:     2019/3/23 13:56
 * Description: Java实现链表结构
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.dataStructure;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Java实现链表结构〉
 * 算法：
 * 遍历
 * 查找
 * 清空
 * 销毁
 * 求长度
 * 排序
 * 删除节点
 * 插入节点
 * @author chenfz
 * @create 2019/3/23
 * @since 1.0.0
 */
public class ListNode<T> {

    public T value;
    // 单指针
    public ListNode<T> next;

    // 插入节点
    public ListNode(T t,ListNode<T> pre){
        this.value = t;
        if (pre != null) {
            this.next = pre.next;
            pre.next = this;
        }
    }

    public ListNode() {
    }

    // 遍历节点
    public static void show(ListNode pointer){
        while (pointer!=null){
            System.out.println(pointer.value);
            pointer = pointer.next;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                '}';
    }
}

class Demo{
    public static void main(String[] args) {
        ListNode<String> node1 = new ListNode<>("haha", null);
        ListNode<String> node2 = new ListNode<>("enen", node1);
        ListNode.show(node1);
    }
}
