/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: MyCircularDeque
 * Author:   chenfz
 * Date:     2021/1/23 19:03
 * Description: 641. 设计循环双端队列
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.enjoy.linkedList;

/**
 * 〈一句话功能简述〉<br>
 * 〈641. 设计循环双端队列〉
 * <p>
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 *
 * @author chenfz
 * @create 2021/1/23
 * @since 1.0.0
 */
class MyCircularDeque<E> {

    transient int size = 0;
    int capacity;
    Node first;
    Node last;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node<Integer> node = new Node<Integer>(null, value, first);
        if (first != null) {
            first.prev = node;
        }
        first = node;
        if (last == null) {
            last = node;
        }
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node<Integer> node = new Node<Integer>(last, value, null);
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null) {
            first = node;
        }
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        Node node = first.next;
        if (node != null) {
            first.next = null;
            node.prev = null;
        } else {
            last = null;
        }
        first = node;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        Node node = last.prev;
        if (node != null) {
            node.next = null;
            last.prev = null;
        } else {
            first = null;
        }
        last = node;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return first == null ? -1 : (Integer) first.item;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return last == null ? -1 : (Integer) last.item;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            sb.append("This deque is empty");
            return sb.toString();
        }
        Node p = first;
        for (int i = 0; i < size; i ++) {
            sb.append("[").append(p.item).append("]");
            p = p.next;
        }
        sb.append(", first == ").append(getFront())
                .append(", last == ").append(getRear())
                .append(", size == ").append(size);
        return sb.toString();
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == capacity;
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
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */