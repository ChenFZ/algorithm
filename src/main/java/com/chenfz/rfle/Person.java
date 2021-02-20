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
import java.lang.reflect.Field;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //私有方法
    private void privateMethod() {
        System.out.println("这是一个私有方法");
    }
}

class Man extends Person {
    public Man(){
        super();
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
    public static void testMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String className = "com.chenfz.rfle.Person";
        Class<Person> clazz = (Class<Person>) Class.forName(className);
        System.out.println("获取clazz对应类中的所有方法，" +
                "不能获取private方法，且获取从父类继承来的所有方法");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + "()");
        }

        System.out.println("打印子类所有声明方法");
        Class<Man> manClazz = (Class<Man>) Class.forName("com.chenfz.rfle.Man");
        Method[] declaredMethods = manClazz.getMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName() + "()");
        }


        System.out.println("__________________________________");
        System.out.println("获取所有方法，包括私有方法" +
                "所有声明的方法，且获取当前类方法");
        methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + "()");
        }

        System.out.println("__________________________________");
        System.out.println("获取指定方法，和获取构造器的差不多，需要方法名称 和参数列表 无参则不写");
        Method method = clazz.getDeclaredMethod("setName", String.class);
        Method privateMethod = clazz.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        System.out.println(method);

        System.out.println("执行我们获取的方法");
        Person person = clazz.newInstance();
        method.invoke(person, "xiaoming");
        privateMethod.invoke(person);
        System.out.println(person);

    }
}

class TestField {
    public static void testField() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class<Person> clazz = (Class<Person>) Class.forName("com.chenfz.rfle.Person");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        System.out.println("获取指定的field");
        Field name = clazz.getDeclaredField("name");
        System.out.println(name.getName());

        System.out.println("获取指定字段的值");
        Person person = new Person("小明", 20);
        Object o = name.get(person);
        System.out.println(name.getName() + "=" + o);

        System.out.println("设置指定字段的值");
        name.set(person, "小红");
        System.out.println(person);

        System.out.println("访问私有的成员变量");
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(person, 21);
        Object o1 = age.get(person);
        System.out.println("age:"+o1);


    }
}

class ConstructorTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //TestConstructor.testConstructor();
        TestMethod.testMethod();
        //TestField.testField();
    }
}


