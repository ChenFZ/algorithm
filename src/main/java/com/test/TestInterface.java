/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: TestInterface
 * Author:   Chen FZ
 * Date:     2021/2/19 15:30
 * Description: 测试接口与抽象类的区别
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试接口与抽象类的区别〉
 *
 * 访问控制修饰符默认是public
 *
 * @author Chen FZ
 * @create 2021/2/19
 * @since 1.0.0
 */
public interface TestInterface {
    public static final int size = 0;
    People people = null;

    public abstract int getValue(int index);

    static int getSize(){
        return size;
    }
    default int getSize2(){
        return size;
    }
}
