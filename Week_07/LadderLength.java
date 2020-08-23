package com.leetcode.week07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 类描述,单词接龙
 *
 * @author zhangjianfu
 * @create 2020-08-24-00-12:54 AM
 */
public class LadderLength {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord)) return 0;

        Set<String> visited = new HashSet<>();

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            if(beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> nextSearchSet = new HashSet<>();

            for(String word:beginSet) {
                char[] chs = word.toCharArray();
                for(int i = 0; i < chs.length;i++) {
                    for (char ch = 'a';ch <= 'z';ch++) {
                        char old = chs[i];
                        chs[i] = ch;
                        String target = String.valueOf(chs);
                        if(endSet.contains(target)) {
                            return step + 1;
                        }
                        if(!visited.contains(target) && wordSet.contains(target)) {
                            nextSearchSet.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = nextSearchSet;
            step++;
        }
        return 0;

    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = new String[] {"hot","dot","dog","lot","log"};
        String[] wordList2 = new String[] {"hot","dot","dog","lot","log","cog"};

        System.out.println(ladderLength(beginWord,endWord,Arrays.asList(wordList)));
        System.out.println(ladderLength(beginWord,endWord,Arrays.asList(wordList2)));
    }
}
