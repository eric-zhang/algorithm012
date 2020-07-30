package com.leetcode.week04;

/**
 * 类描述
 *
 * @author zhangjianfu
 * @create 2020-07-31-01-1:59 AM
 */
public class MaxProfit {
    /**
     *  思想：只要有盈利就操作，没有盈利就不操作，所以肯定可以利益最大化
     *   即：通过前后两天的利润，负的话就是亏本，即不操作，正的话就是盈利，即可以操作，每次都落袋为安，把盈利收入口袋，
     *   把所有操作盈利到的钱累加起来就是最利益最大化
      */

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int profit = 0;
        for(int i = 1;i < len ; i++) {
            int temp = prices[i] - prices[i - 1];
            if ( temp > 0 )  profit += temp;
        }
        return profit;
    }

    public static void main(String[] args) {
        MaxProfit ma = new MaxProfit();
        int[] prices = new int[] {5,3,3,6,3,5,7};
        int expect = 7;
        System.out.println(ma.maxProfit(prices) == expect);
    }

}
