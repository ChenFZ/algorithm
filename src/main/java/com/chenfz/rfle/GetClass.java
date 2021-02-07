/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: GetClass
 * Author:   Chen FZ
 * Date:     2021/2/7 19:33
 * Description: Java中的反射和动态代理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.rfle;

import com.chenfz.dataStructure.ListNode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈搞懂Java反射和JDK里的动态代理〉
 *
 * @author Chen FZ
 * @create 2021/2/7
 * @since 1.0.0
 */
public class GetClass {

    public static void main(String[] args) {
        //1. 通过类名获取
        Class<ListNode> listNodeClass = ListNode.class;
        //2. 通过实例来获取
        ListNode<Integer> node = new ListNode<>();
        Class<? extends ListNode> aClass = node.getClass();
        try {
            //3. 通过类的全限定名称（包名加类名）Class.forName来获取
            Class<?> forName = Class.forName("com.chenfz.dataStructure.ListNode");
            ListNode instance = (ListNode) forName.newInstance();
            instance.value = 1;
            System.out.println(instance.toString());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
