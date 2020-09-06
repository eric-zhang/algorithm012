package com.leetcode.week08;

/**
 * 类描述
 *
 * @author zhangjianfu
 * @create 2020-09-06-23-11:39 PM
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length -1);
    }

    private int mergeSort(int[] nums,int start,int end) {
        if ( start >= end ) return 0;
        int mid = (start + end) >> 1;
        int cnt = mergeSort(nums,start,mid) + mergeSort(nums,mid + 1,end);
        for (int i = start,j = mid +1; i<= mid;i++) {
            while ( j <= end && nums[i]/2.0 > nums[j]) j++;
            cnt += j - (mid + 1);
        }
        //Arrays.sort(nums,start,end+1);
        merge(nums,start,mid,end);
        return cnt;
    }

    private void merge(int[] arr,int left,int mid,int right) {
        int[] temp = new int[right - left + 1];
        int i = left,j = mid + 1,k = 0;
        while(i <= mid && j <= right){
            temp[k++] = arr[i] <= arr[j] ? arr[i++]:arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int[] nums = new int[]{1,3,2,3,1};
        System.out.println(reversePairs.reversePairs(nums));
    }

}
