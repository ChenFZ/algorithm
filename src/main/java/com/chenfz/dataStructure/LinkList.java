/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LinkList
 * Author:   chenfz
 * Date:     2019/3/23 14:24
 * Description: 链表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.dataStructure;

/**
 * 〈一句话功能简述〉<br>
 * 〈链表〉
 *
 * @author chenfz
 * @create 2019/3/23
 * @since 1.0.0
 */
public class LinkList {

    public static Node head = new Node(0);

    /**
     * 创建链表，增加节点
     *
     * @param value 要添加的数据
     */
    public static void insert(int value) {
        final Node node = new Node(value);
        Node temp = head;

        // 寻找尾节点
        while (temp.next != null) {
            temp = temp.next;
        }
        // 已经包括了头节点.next为null的情况了～
        temp.next = node;
    }

    /**
     * 遍历链表
     *
     * @param head
     */
    public static void traverse(Node head) {
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     * 获取链表的长度
     * @param head 头指针
     */
    public static int linkListLength(Node head) {
        Node temp = head.next;
        int length = 0;
        while (temp!=null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 插入节点
     * @param head  头指针
     * @param index 要插入的位置
     * @param value 要插入的值
     */
    public static void insertNode(Node head, int index, int value) {
        // 判断插入的位置是否合法
        if (index<1 || index>linkListLength(head)+1){
            System.out.println("插入位置不合法");
            return;
        }
        Node temp = head;
        while (index!=1){
            index--;
            temp = temp.next;
        }
        Node node = new Node(value,temp.next);
        temp.next = node;
    }

    /**
     * 删除节点
     * @param head 头指针
     * @param index 要删除的位置
     */
    public static void deleteNode(Node head,int index){
        if (index<1 || index>linkListLength(head)){
            System.out.println("删除位置不合法");
            return;
        }
        Node temp = head;
        while (index!=1){
            index--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    /**
     * 排序
     * 暂时可以用冒泡来做
     * @param head
     */
    public static void sortLinkList(Node head){
        Node currentNode;
        Node nextNode;
        for (currentNode = head.next;currentNode.next!=null;currentNode = currentNode.next) {
            for (nextNode = currentNode.next;nextNode!=null;nextNode = nextNode.next){
                if (currentNode.data>nextNode.data) {
                    int data = currentNode.data;
                    currentNode.data = nextNode.data;
                    nextNode.data = data;
                }
            }
        }
    }

    /**
     * 找到链表中倒数第k个节点
     * @param k
     */
    public static Node findNode(Node head,int k){
        if (k<1 || k>linkListLength(head)){
            System.out.println("输入位置不合法");
            return null;
        }
        int length = linkListLength(head);
        int index = length - k + 1;
        Node temp = head.next;
        while (index!=1){
            index--;
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 删除链表重复数据
     * @param head
     */
    public static void deleteDuplecate(Node head){
        Node currentNode = head.next;
        while (currentNode.next!=null){
            Node nextNode = currentNode;
            while (nextNode.next!=null){
                if (currentNode.data == nextNode.next.data){
                    // 相同则删除
                    nextNode.next = nextNode.next.next;
                }else{
                    nextNode = nextNode.next;
                }
            }
            currentNode = currentNode.next;
        }
    }

    /**
     * 查询链表的中间节点
     * @param head
     */
    public static Node searchMid(Node head){
        Node p1 = head;
        Node p2 = head;
        while (p2!=null&&p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
    /**
     * 通过递归从尾到头输出单链表
     * @param head
     */
    public static void printListReversely(Node head){
        if (head!=null){
            printListReversely(head.next);
            System.out.println(head.data);
        }
    }
    /**
     * 反转链表 自己的递归实现
     * @param head
     */
    public static Node reverseLinkList(Node head){
        if (head.next!=null){
            Node node = reverseLinkList(head.next);
            Node res = node;
            while (node.next!=null){
                node = node.next;
            }
            node.next = head;
            head.next = null;
            return res;
        }else{
            return head;
        }
    }
    /**
     * 反转链表 递归实现
     * @param
     */
    public static Node execute(Node node) {
        Node prev = null;
        if (node == null || node.next == null) {
            prev = node;
        } else {
            Node tmp = execute(node.next);
            node.next.next = node;
            node.next = null;
            prev = tmp;
        }
        return prev;
    }
    /**
     * 反转链表 非递归实现
     * @param
     */
    public static Node execute2(Node node) {
        Node prev = null;
        while (node!=null){
            // 记录当前节点
            Node temp = node;
            // 后一个节点，遍历控制条件
            node = node.next;
            // 当前节点拿出来，放到链表头
            temp.next = prev;
            // 返回链表头
            prev = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        final LinkList linkList = new LinkList();
        linkList.insert(1);
        linkList.insert(2);
        linkList.insert(3);
        linkList.insert(4);
        linkList.insertNode(head,5,5);
//        linkList.deleteNode(head,3);
//        linkList.sortLinkList(head);
//        System.out.println(findNode(head,5).data);
//        deleteDuplecate(head);
//        System.out.println(searchMid(head).data);
//        printListReversely(head);
//        head.next = reverseLinkList(head.next);
        head.next = execute(head.next);
        traverse(head);
    }
}