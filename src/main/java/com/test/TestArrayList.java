/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: TestArrayList
 * Author:   chenfz
 * Date:     2021/2/23 14:36
 * Description: java集合之列表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈java集合之列表〉
 *
 * @author chenfz
 * @create 2021/2/23
 * @since 1.0.0
 */
public class TestArrayList {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();

        Outer outer = new Outer();
        Outer.inner inner = outer.new inner();
        Outer.staticInner.name = "static change value";
        Outer.staticInner staticInner = new Outer.staticInner("test case1");
        String name = staticInner.getName();
        System.out.println(name);
        System.out.println(name + staticInner.field);

        int a = '5' - '1';
        int b = ~0;
        System.out.println(a+"+"+b);
    }
}
