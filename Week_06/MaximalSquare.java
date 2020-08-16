package com.leetcode.week06;

/**
 * 类描述
 *
 * @author zhangjianfu
 * @create 2020-08-17-01-1:57 AM
 */
public class MaximalSquare {
    // dp 方程： dp[i][j] = Min(dp[i-1][j - 1],dp[i - 1][j],dp[i][j-1]) + 1;
    public static int maximalSquare(char[][] matrix) {
        int maxSize = 0;

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSize;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] grid = new int[m][n];
        for ( int i  = 0; i < m;i++) {
            for (int j = 0;j < n; j++) {
                if(matrix[i][j] == '1') {
                    if(i == 0 || j == 0) {
                        grid[i][j] = 1;
                    }
                    if( i > 0 && j > 0 ){
                        int temp = Math.min(grid[i - 1][j - 1],grid[i][j - 1]);
                        grid[i][j] = Math.min(grid[i-1][j],temp) + 1;
                    }
                    maxSize = Math.max(maxSize,grid[i][j]);
                }
            }
        }
        return maxSize * maxSize;
    }

    public static void main(String[] args) {
        char[][] martix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','1','1','1'}};
        System.out.println(maximalSquare(martix));
    }

}
