package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述
 *
 * @author zhangjianfu
 * @create 2020-07-18-18-6:58 PM
 */
public class Anagram {

    public static boolean isAnagramForHashMap(String s,String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character,Integer> wordCount = new HashMap<>();
        for(int i = 0; i < s.length() ; i ++) {
            Integer count =  wordCount.getOrDefault(s.charAt(i),0) + 1;
            wordCount.put(s.charAt(i),count);
        }
        for(int i = 0; i < t.length(); i++) {
            if(wordCount.containsKey(t.charAt(i))){
                Integer count =  wordCount.getOrDefault(t.charAt(i),0);
                count = count - 1;
                if(count == 0) {
                    wordCount.remove(t.charAt(i));
                }else {
                    wordCount.put(t.charAt(i),count);
                }
            }
        }
        return wordCount.size() == 0;
    }

    public static boolean isAnagramForCharArray(String s,String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for(int i = 0;i < s.length();i ++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int cou:counter){
            if(cou != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String source = "caete" ;
        String target = "teeca";
        String source1 = "a";
        String target1 = "b";
        String target2 = "a";
        System.out.println(isAnagramForHashMap(source,target));
        System.out.println(isAnagramForHashMap(source1,target1));
        System.out.println(isAnagramForCharArray(source,target));
        System.out.println(isAnagramForCharArray(source1,target1));
        System.out.println(isAnagramForHashMap(source1,target2));
        System.out.println(isAnagramForCharArray(source1,target2));
    }


}
