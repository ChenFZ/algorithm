/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Node
 * Author:   chenfz
 * Date:     2019/3/23 14:20
 * Description: 比较完整的链表节点设计
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.dataStructure;

/**
 * 〈一句话功能简述〉<br> 
 * 〈比较完整的链表节点设计〉
 *
 * @author chenfz
 * @create 2019/3/23
 * @since 1.0.0
 */
public class Node {

    public int data;
    public Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }



}
