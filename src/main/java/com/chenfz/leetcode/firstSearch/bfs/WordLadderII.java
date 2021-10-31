/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: WordLadderII
 * Author:   chenfz
 * Date:     2021/8/1 10:39
 * Description: word ladder
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.firstSearch.bfs;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 126 单词接龙
 * <p>
 * 按字典wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 * <p>
 * 每对相邻的单词之间仅有单个字母不同。
 * 转换过程中的每个单词 si（1 <= i <= k）必须是字典wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * 解释：存在 2 种最短的转换序列：
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 * 示例 2：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：[]
 * 解释：endWord "cog" 不在字典 wordList 中，所以不存在符合要求的转换序列。
 *
 * @author chenfz
 * @create 2021/8/1
 * @since 1.0.0
 */
public class WordLadderII {
    public static void main(String[] args) {
        WordLadderII wordLadderII = new WordLadderII();
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        List<List<String>> res = wordLadderII.MyfindLadders(beginWord, endWord, wordList);
        for (List list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<String>> MyfindLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        //字典
        HashSet<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return res;
        }
        dict.remove(beginWord);
        int step = 0;
        //变化后的单词出现在第几步
        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, step);
        step = 1;
        //key中的单词是从value中一步改变过来的
        Map<String, List<String>> from = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        boolean found = false;
        int wordLen = beginWord.length();
        // 广度优先搜索，整理出from map，next word and current word list
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                char[] currChars = currentWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char origin = currChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        currChars[j] = c;
                        String nextWord = String.valueOf(currChars);
                        //同一层节点出现过了的话，记录到from中
                        if (steps.containsKey(nextWord) && steps.get(nextWord) == step) {
                            from.get(nextWord).add(currentWord);
                        }
                        if (!dict.contains(nextWord)) {
                            continue;
                        }
                        //出现过一次后，不用再重复出现
                        dict.remove(nextWord);
                        //第一层节点遍历之后，插入的第二层节点
                        queue.offer(nextWord);

                        steps.put(nextWord, step);
                        from.putIfAbsent(nextWord, new ArrayList<>());
                        from.get(nextWord).add(currentWord);
                        if (nextWord.equals(endWord)) {
                            found = true;
                        }
                    }
                    currChars[j] = origin;
                }
            }
            step++;
            if (found) {
                break;
            }
        }

        // 深度优先搜索找出所有路径
        if (found){
            Deque<String> path = new LinkedList<>();
            path.add(endWord);
            dfs(from, path, beginWord, endWord, res);
        }

        return res;
    }

    private void dfs(Map<String, List<String>> from, Deque<String> path, String beginWord, String cur, List<List<String>> res) {
        if(cur.equals(beginWord)){
            res.add(new ArrayList<>(path));
            return;
        }
        for (String nextWord: from.get(cur)) {
            path.addFirst(nextWord);
            dfs(from, path, beginWord, nextWord, res);
            path.removeFirst();
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        // 因为需要快速判断扩展出的单词是否在 wordList 里，因此需要将 wordList 存入哈希表，这里命名为「字典」
        Set<String> dict = new HashSet<>(wordList);
        // 特殊用例判断
        if (!dict.contains(endWord)) {
            return res;
        }

        dict.remove(beginWord);

        // 第 1 步：广度优先遍历建图
        // 记录扩展出的单词是在第几次扩展的时候得到的，key：单词，value：在广度优先遍历的第几层
        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);
        // 记录了单词是从哪些单词扩展而来，key：单词，value：单词列表，这些单词可以变换到 key ，它们是一对多关系
        Map<String, List<String>> from = new HashMap<>();
        int step = 1;
        boolean found = false;
        int wordLen = beginWord.length();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                char[] charArray = currWord.toCharArray();
                // 将每一位替换成 26 个小写英文字母
                for (int j = 0; j < wordLen; j++) {
                    char origin = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;
                        String nextWord = String.valueOf(charArray);
                        if (steps.containsKey(nextWord) && step == steps.get(nextWord)) {
                            from.get(nextWord).add(currWord);
                        }
                        if (!dict.contains(nextWord)) {
                            continue;
                        }
                        // 如果从一个单词扩展出来的单词以前遍历过，距离一定更远，为了避免搜索到已经遍历到，且距离更远的单词，需要将它从 dict 中删除
                        dict.remove(nextWord);
                        // 这一层扩展出的单词进入队列
                        queue.offer(nextWord);

                        // 记录 nextWord 从 currWord 而来
                        from.putIfAbsent(nextWord, new ArrayList<>());
                        from.get(nextWord).add(currWord);
                        // 记录 nextWord 的 step
                        steps.put(nextWord, step);
                        if (nextWord.equals(endWord)) {
                            found = true;
                        }
                    }
                    charArray[j] = origin;
                }
            }
            step++;
            if (found) {
                break;
            }
        }

        // 第 2 步：深度优先遍历找到所有解，从 endWord 恢复到 beginWord ，所以每次尝试操作 path 列表的头部
        if (found) {
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            dfs(from, path, beginWord, endWord, res);
        }
        return res;
    }

    //public void dfs(Map<String, List<String>> from, Deque<String> path, String beginWord, String cur, List<List<String>> res) {
    //    if (cur.equals(beginWord)) {
    //        res.add(new ArrayList<>(path));
    //        return;
    //    }
    //    for (String precursor : from.get(cur)) {
    //        path.addFirst(precursor);
    //        dfs(from, path, beginWord, precursor, res);
    //        path.removeFirst();
    //    }
    //}
}
