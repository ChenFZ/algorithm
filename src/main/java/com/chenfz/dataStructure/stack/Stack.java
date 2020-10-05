/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Stack
 * Author:   chenfz
 * Date:     2019/3/24 20:22
 * Description: 使用链表实现动态栈
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.dataStructure.stack;

import com.chenfz.dataStructure.Node;

/**
 * 〈一句话功能简述〉<br> 
 * 〈使用链表实现动态栈〉
 *
 * @author chenfz
 * @create 2019/3/24
 * @since 1.0.0
 */
public class Stack {

    public Node stackTop;
    public Node stackBottom;

    public Stack(){
    }

    /**
     * 进栈
     */
    public void push(int data){
        Node node = new Node(data);
        node.next = stackTop;
        stackTop = node;
        if (stackBottom==null) stackBottom=stackTop;
    }
    /**
     * 遍历栈 只要栈顶元素的指针不指向栈底，那么就一直输出遍历结果：
     */
    public static void traverse(Stack stack){
        Node stackTop = stack.stackTop;
        while (stackTop!=stack.stackBottom){
            System.out.println(stackTop.data);
            stackTop = stackTop.next;
        }
        System.out.println(stackTop.data);
    }
}
class Demo{
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Stack.traverse(stack);
        Stack.traverse(stack);
        System.out.println(isEven(10));

    }

    public static boolean isEven(int n){
        return (n&0b1)==0;
    }
}
