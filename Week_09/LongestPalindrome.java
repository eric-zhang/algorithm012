package com.leetcode.week09;

import java.util.Arrays;

/**
 * 类描述
 *
 * @author zhangjianfu
 * @create 2020-09-07-00-12:03 AM
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], false);
        }

        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }


        char[] charArray = s.toCharArray();
        int maxLen = 1;
        int start = 0;

        for (int j = 1; j < len; j++) {
            // 只有下面这一行和「参考代码 2」不同，i 正着写、倒过来写都行，因为子串都有参考值
            for (int i = j - 1; i >= 0; i--) {

                if (charArray[i] == charArray[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i, j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

}
