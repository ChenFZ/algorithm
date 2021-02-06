/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: FindLongestWord
 * Author:   Chen FZ
 * Date:     2021/2/6 10:56
 * Description: 524. 通过删除字母匹配到字典里最长单词 Longest Word in Dictionary through Deleting (Medium)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.twoPointers;

import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈524. 通过删除字母匹配到字典里最长单词 Longest Word in Dictionary through Deleting (Medium)〉
 *
 * @author Chen FZ
 * @create 2021/2/6
 * @since 1.0.0
 */
public class FindLongestWord {

    public static void main(String[] args) {
        FindLongestWord findLongestWord = new FindLongestWord();
        //"bab"  ["ba","ab","a","b"]
        //s = "abpcplea", d = ["ale","apple","monkey","plea"]
        String s = "abpcplea";
        String[] sArray = {"ale","apple","monkey","plea"};
        System.out.println(findLongestWord.findLongestWord(s, Arrays.asList(sArray)));
    }

    public String findLongestWord(String s, List<String> d) {
        if (d.size() == 0) {
            return "";
        }
        int maxLen = 0;
        String res = "";
        char[] charArrayS = s.toCharArray();
        for (int i = 0; i < d.size(); i++) {
            String temp = d.get(i);
            char[] charArrayD = temp.toCharArray();
            int pointerS = 0, pointerD = 0;
            for (; pointerS < charArrayS.length && pointerD < charArrayD.length; pointerS++) {
                if (charArrayS[pointerS] == charArrayD[pointerD]) {
                    pointerD++;
                }
            }
            if (pointerD == charArrayD.length && charArrayD.length>=maxLen){
                if(charArrayD.length>maxLen){
                    res = temp;
                }else{
                    if(res == "" || res.compareTo(temp)>0){
                        res = temp;
                    }
                }

                maxLen = charArrayD.length;
            }
        }
        if(res==""){
            return "";
        }
        return res;
    }
}
