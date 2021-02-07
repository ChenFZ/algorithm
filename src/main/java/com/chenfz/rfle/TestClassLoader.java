/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: TestClassLoader
 * Author:   Chen FZ
 * Date:     2021/2/7 20:09
 * Description: 系统的类加载器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.rfle;

/**
 * 〈一句话功能简述〉<br>
 * 〈系统的类加载器〉
 *
 * @author Chen FZ
 * @create 2021/2/7
 * @since 1.0.0
 */
public class TestClassLoader {

    public static void testClassLoader() throws ClassNotFoundException {
        //1. 获取一个系统的类加载器（可以获取，当前这个类就是它加载的）
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);

    //    2. 获取系统类加载器的父类加载器（扩展加载器，可以获取）
        classLoader = classLoader.getParent();
        System.out.println(classLoader);

    //    3. 获取扩展类加载器（引用类加载器，不可获取）
        classLoader = classLoader.getParent();
        System.out.println(classLoader);

    //    4. 获取当前类是哪个类加载器(系统加载器)
        ClassLoader aClass = Class.forName("com.chenfz.rfle.RelectionTest").getClassLoader();
        System.out.println(aClass);

    //    5. 测试JDK提供的Object类 由那个类加载器加载的（引导类）
        ClassLoader aClass1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(aClass1);
    }
}

class RelectionTest {
    public static void main(String[] args) throws ClassNotFoundException {
        TestClassLoader.testClassLoader();
    }
}