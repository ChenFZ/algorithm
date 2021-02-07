/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: Person
 * Author:   Chen FZ
 * Date:     2021/2/7 20:25
 * Description: 获取构造器对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.rfle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br>
 * 〈获取构造器对象〉
 *
 * @author Chen FZ
 * @create 2021/2/7
 * @since 1.0.0
 */
public class Person {
    String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("this is setName");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("this is setAge");
    }

    /***
     * 包含一个带参的构造方法和不带参的构造方法
     * @param name
     * @param age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    //私有方法
    private void privateMethod() {
        System.out.println("这是一个私有方法");
    }
}

class TestConstructor {
    public static void testConstructor() throws ClassNotFoundException, NoSuchMethodException {
        String className = "com.chenfz.rfle.Person";
        Class<Person> clazz = (Class<Person>) Class.forName(className);
        System.out.println("获取全部的Constructor对象------");
        Constructor<Person>[] constructors = (Constructor<Person>[]) clazz.getConstructors();
        for (Constructor<Person> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("获取某一个Constructor对象 需要参数列表----");
        Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor);

        System.out.println("调用Constructor的newInstance方法创建对象----");
        try {
            Person person = constructor.newInstance("xiaoWang", 22);
            System.out.println(person.getName());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class TestMethod {
    public static void testMethod() throws ClassNotFoundException, NoSuchMethodException {
        String className = "com.chenfz.rfle.Person";
        Class<Person> clazz = (Class<Person>) Class.forName(className);
        System.out.println("获取clazz对应类中的所有方法，" +
                "不能获取private方法，且获取从父类继承来的所有方法");
        Method[] methods = clazz.getMethods();
        for (Method method:methods) {
            System.out.println(method.getName()+"()");
        }

        System.out.println("__________________________________");
        System.out.println("获取所有方法，包括私有方法" +
                "所有声明的方法，且获取当前类方法");
        methods = clazz.getDeclaredMethods();
        for (Method method:methods) {
            System.out.println(method.getName()+"()");
        }

    }
}

class ConstructorTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //TestConstructor.testConstructor();
        TestMethod.testMethod();

    }
}


