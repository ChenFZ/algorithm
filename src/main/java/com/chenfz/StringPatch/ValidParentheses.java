/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ValidParentheses
 * Author:   chenfz
 * Date:     2019/3/12 19:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.StringPatch;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 *
 * @author chenfz
 * @create 2019/3/12
 * @since 1.0.0
 */
public class ValidParentheses {

    public static void main(String[] args) {
        final boolean valid = isValid("{");
        System.out.println(valid);
    }

    public static boolean isValid(String s) {

        char[] chars = s.toCharArray();
        char[] left = new char[chars.length];
        int counter = 0;
        Map<Character, Character> map = new HashMap() {
        };
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (int i = 0; i < chars.length; i++) {
            Character value = map.get(chars[i]);
            if (value != null) {
                if (counter>0 && value == left[--counter])
                    continue;
                else
                    return false;
            } else {
                // map中找不到说明为左括号
                left[counter++] = chars[i];
            }
        }
        if (counter!=0) return false;
        return true;
    }
}
