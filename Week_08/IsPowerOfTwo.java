package com.leetcode.week08;

/**
 * 类描述
 *
 * @author zhangjianfu
 */
public class IsPowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && ( n & (n -1) ) == 0 ;
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while(n > 0) {
            n &= (n - 1);
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(256  * 256));
        System.out.println(isPowerOfTwo(256  * 257));
        System.out.println(hammingWeight(256  * 257));
        System.out.println(Integer.bitCount(256  * 257));
        System.out.println(Integer.bitCount(-0));
        System.out.println(Integer.bitCount(-1));
    }



}
