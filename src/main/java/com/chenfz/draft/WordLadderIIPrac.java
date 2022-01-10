/**
 * Copyright (C), 2015-2022
 * Description:
 * <author>          <time>          <version>          <desc>
 * chenfz           2022/1/3 12:29           1.0              描述
 */
package com.chenfz.draft;

import java.util.*;

public class WordLadderIIPrac {
    public static void main(String[] args) {
        WordLadderIIPrac wordLadderII = new WordLadderIIPrac();
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> res = wordLadderII.findLadders(beginWord, endWord, wordList);
        for (List list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    List<List<String>> res;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        res = new ArrayList<>();
        //字典
        HashSet<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)){
            return res;
        }
        //from 来自
        HashMap<String, List<String>> from = new HashMap<>();
        //步骤 分层
        int step = 0;
        HashMap<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, step);
        step++;
        int wordLen = beginWord.length();
        Deque<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        boolean found = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                char[] curChars = curWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char originChar = curChars[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        curChars[j] = k;
                        String nextWord = String.valueOf(curChars);
                        //出现过一次后，不用再重复出现, 但是对于同一层，允许存在的补偿
                        if (steps.containsKey(nextWord) && steps.get(nextWord) == step){
                            from.get(nextWord).add(curWord);
                        }
                        if (dict.contains(nextWord)){
                            //出现过一次后，不用再重复出现
                            dict.remove(nextWord);
                            //第一次的处理
                            steps.put(nextWord, step);
                            queue.offer(nextWord);
                            from.putIfAbsent(nextWord, new ArrayList<>());
                            from.get(nextWord).add(curWord);
                            if (nextWord.equals(endWord)){
                                found = true;
                            }
                        }
                    }
                    curChars[j] = originChar;
                }
            }
            step++;
            if (found){
                break;
            }
        }
        if (found){
            Deque<String> path = new LinkedList<>();
            path.add(endWord);
            dfs(from, path, beginWord, endWord);
        }
        return res;
    }

    private void dfs(HashMap<String, List<String>> from, Deque<String> path, String beginWord, String endWord) {
        if (endWord.equals(beginWord)){
            res.add(new ArrayList<>(path));
            return;
        }
        for (String nextWord: from.get(endWord)){
            path.addFirst(nextWord);
            dfs(from, path, beginWord, nextWord);
            path.removeFirst();
        }
    }
}
