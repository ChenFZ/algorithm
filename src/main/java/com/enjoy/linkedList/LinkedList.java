/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: LinkedList
 * Author:   chenfz
 * Date:     2021/1/11 19:40
 * Description: 单链表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.enjoy.linkedList;

/**
 * 〈一句话功能简述〉<br>
 * 〈单链表〉
 *
 * @author chenfz
 * @create 2021/1/11
 * @since 1.0.0
 */
public class LinkedList<T> {

    Node list;
    int size;

    public LinkedList() {
        size = 0;
    }

    //    添加节点
//    头部添加
    public void put(T data) {
        Node head = list;
        Node curNode = new Node(data, list);
        list = curNode;
        size++;
    }

    public void put(int index, T data) {
        Node node = getNode(index - 1);
        Node insertNode = new Node(data, node.next);
        node.next = insertNode;
        size++;
    }


    //    删除节点
//    删除头部节点
    public T remove() {
        Node node = list;
        list = list.next;
        node.next = null;   // GC回收
        size--;
        return node.val;
    }

    //    删除指定节点
    public T remove(int index) {
        Node node = getNode(index - 1);
        Node temp = node.next;
        node.next = node.next.next;
        size--;
        temp.next = null;
        return temp.val;
    }

    //    删除尾部节点
    public T removeLast() {
        Node node = getNode(size - 2);
        Node temp = node.next;
        node.next = null;
        size--;
        return temp.val;
    }

    //    修改节点
    public void set(int index, T newData) {
        Node node = getNode(index);
        node.val = newData;
    }

    //    查询节点
    public T get() {

        return list == null ? null : list.val;
    }

    public T get(int index) {
        checkElementIndex(index);
        Node node = getNode(index);
        return node == null ? null : node.val;
    }

    Node getNode(int index) {
        checkElementIndex(index);
        Node node = list;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        //while (node.next!=null) {
        //    node = node.next;
        //}
        return node;
    }

    public void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Node node = list;
        for (int i = 0; i < size; i++) {
            stringBuffer.append(node.val+"  ");
            node = node.next;
        }
        return stringBuffer.toString();
    }


    //    节点信息
    class Node {
        T val;
        Node next;

        public Node(T data, Node node) {
            this.val = data;
            this.next = node;
        }

        public Node(T data) {
            this.val = data;
            this.next = null;
        }
    }
}
