/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: TestConstructor
 * Author:   Chen FZ
 * Date:     2021/2/19 15:16
 * Description: 父类无参构造器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 〈一句话功能简述〉<br>
 * 〈父类无参构造器〉
 *
 * @author Chen FZ
 * @create 2021/2/19
 * @since 1.0.0
 */
public class TestConstructor {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        People people = new People(23, "xiaoming");
        people.explain();
    }
}

class Asia extends People {

    public Asia(int age, String name) {
        super(age, name);
    }
}

class People {
    int age;
    String name;
    static final String explain = "This is a people class, include two fields: age and name.";

    public People(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void explain(){
        System.out.println(explain);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return age == people.age && Objects.equals(name, people.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
