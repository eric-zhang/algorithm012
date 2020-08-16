package com.leetcode.week06;

/**
 * 类描述
 *
 * @author zhangjianfu
 * @create 2020-08-17-00-12:30 AM
 */
public class MinPathSum {
    // 找出重复子问题
    // 状态数组：除了首行和首列，到达每个格子有两种走法，对应到这个格子的数字总和就有两种，取小的那个放到到达的格子
    // dp方程：dp[i][j] = Min(dp[i + 1][j],dp[i][j + 1]) + dp[i][j];

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i ++ ) {
            for(int j = 0; j< n;j++) {
                if(i == 0 && j > 0) {
                    grid[i][j] +=grid[i][j-1];
                }
                if(j == 0 && i > 0) {
                    grid[i][j] += grid[i - 1][j];
                }
                if(i > 0 && j > 0) {
                    grid[i][j] = Math.min(grid[i][j-1] ,grid[i-1][j]) + grid[i][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1,5},{1,5,1,3},{4,2,1,2}};
        System.out.println(minPathSum(grid));
    }



}
