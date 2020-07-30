package com.leetcode.week04;

import java.util.Arrays;

/**
 * 类描述
 *
 * @author zhangjianfu
 * @create 2020-07-31-01-1:56 AM
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        int gi = 0;
        int num = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int glen = g.length,slen = s.length;
        for(int si = 0;si < slen; si++) {
            if(gi < glen && g[gi] <= s[si]) {
                num ++;
                gi++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        FindContentChildren findContentChildren = new FindContentChildren();
        int[] g = new int[] {1,2,2};
        int[] s = new int[] {1,1,2,3,4};
        System.out.println(findContentChildren.findContentChildren(g,s));
    }
}
