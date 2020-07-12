package com.leetcode;

import java.util.Objects;

/**
 * 移除重复值
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author zhangjianfu
 */
public class RemoveDuplicates {

    // 在允许多余的空间情况下，使用双端队列，
    // 1.申请一个队列，入队列时先跟顶元素比较
    // 2.跟顶元素相等时，就放到队列尾巴，大于顶元素时，就放入队头，同时记录放入队头的次数
    // 3.数组遍历完之后，根据记录的放入队头的个数，将队列头的元素放到对应的数组位置
    // 这样的时间复杂度为O(n),空间复杂度也为 O(n)

    /**
     * 解法: 使用双指针，源数组是有序数组，
     * 慢指针指向已处理的排在最后的值，快指针不断往前搜索，
     * 如果快指针指向的值大于慢指针指向的值，则将慢指针的下一个位置的值跟当前快指针的值交换，同时慢指针和快指针往前移动一步
     * 如果快指针指向的值等于慢指针指向的值，则指移动快指针即可
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if(Objects.isNull(nums) || nums.length == 1){
            return Objects.isNull(nums)?0:1;
        }
        int j = 0;
        int length = nums.length;
        for (int i = 1; i < length ;i++){
            if(nums[j] < nums[i] ){
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {0,0,0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums1));
        System.out.println(removeDuplicates(nums2));
        for (int i : nums1) {
            System.out.print(" " + i) ;
        }

        for (int i : nums2) {
            System.out.print(" " + i) ;
        }
    }





}
