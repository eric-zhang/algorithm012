package com.leetcode.week09;

import java.util.Stack;

/**
 * 类描述
 *
 * @author zhangjianfu
 * @create 2020-09-07-00-12:07 AM
 */
public class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack();
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s1 = "a-bC-dEf-ghIj";
        String expect1 = "j-Ih-gfE-dCba";
        System.out.println(reverseOnlyLetters(s1).equals(expect1));
    }



}
