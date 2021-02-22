/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: LruLinkedList
 * Author:   chenfz
 * Date:     2021/1/17 9:42
 * Description: 手写实现lru算法的链表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.enjoy.linkedList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈手写实现lru算法的链表〉
 *
 * @author chenfz
 * @create 2021/1/17
 * @since 1.0.0
 */
public class LruLinkedList<T> extends LinkedList<T> {

    int memory_size;
    private static final int defaule_length = 5;

    public LruLinkedList() {
        this(defaule_length);
    }

    public LruLinkedList(int memory_size) {
        this.memory_size = memory_size;
    }

    public void lruPut(T data){
        if(size>=memory_size){
            lruRemove();
        }
        put(data);
    }

    public T lruRemove(){
        return removeLast();
    }

    public T lruGet(int index){
        checkElementIndex(index);
        Node node = getNode(index - 1);
        Node newHead = node.next;
        node.next = node.next.next;
        newHead.next = list;
        list = newHead;
        return newHead.val;
    }

    public static void main(String[] args) {
        LruLinkedList<Integer> list = new LruLinkedList<>(6);
        for (int i = 0; i < 5; i++) {
            list.lruPut(i);
        }
        list.lruPut(6);
        System.out.println(list.toString());
        list.lruGet(2);
        System.out.println(list.toString());
        list.lruPut(7);
        System.out.println(list.toString());

    }
}
