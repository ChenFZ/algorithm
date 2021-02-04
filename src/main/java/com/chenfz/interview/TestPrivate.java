/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: TestPrivate
 * Author:   Chen FZ
 * Date:     2021/2/3 9:54
 * Description: 测试私有成员变量
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试私有成员变量〉
 *
 * @author Chen FZ
 * @create 2021/2/3
 * @since 1.0.0
 */
public class TestPrivate {
    class User {
        public String userName;

        public User(String userName) {
            this.userName = userName;
        }
    }

    private List<User> userlist = new ArrayList<>();

    private List<User> users = new ArrayList<>();

    private Set<User> set = new TreeSet<>();

    public TestPrivate addUserList(User user) {
        this.userlist.add(user);
        return this;
    }
}
