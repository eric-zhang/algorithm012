package com.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author zhangjianfu
 * @create 2020-07-12-22-10:38 PM
 */
public class MoveZeroes {

    // 解法: 在不允许多余的空间条件下，数组的移动一般可以采用双指针(一快一慢)来解决；跟移除重复值的思路查不多

    public static void moveZeroes(int[] nums) {
        if(Objects.isNull(nums)) {
            return;
        }

        int length = nums.length;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if(nums[i] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0,1,0,3,12};
        int[] nums2 = {1,0,6,0,5,0,12};
        moveZeroes(nums1);
        moveZeroes(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }



}
