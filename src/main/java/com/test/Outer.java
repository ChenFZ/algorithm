/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: Outer
 * Author:   chenfz
 * Date:     2021/2/23 14:55
 * Description: 内部类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈内部类〉
 *
 * @author chenfz
 * @create 2021/2/23
 * @since 1.0.0
 */
class Outer {
    static String name;

    class inner{
        String name;

    }

    //如果一个类要被声明为static的，只有一种情况，就是静态内部类。
    static class staticInner{
        static String name = "staticInner";
        String field;

        public staticInner(String field) {
            this.field = field;
        }

        static String getName(){
            return name;
        }
    }
}
