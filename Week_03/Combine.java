package com.leetcode.week03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 类描述
 *
 * @author zhangjianfu
 * @create 2020-07-26-23-11:53 PM
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        _doCombine(1,n,k,new LinkedList<Integer>() ,result);
        return result;
    }

    private void _doCombine(int i, int n,int k, LinkedList<Integer> curr, List<List<Integer>> result) {

        // terminator
        if( curr.size() == k) {
           result.add(new LinkedList<>(curr));
           return;
        }

        for(int j = i;  j < n + 1; ++j) {
            // process curr logic
            curr.add(j);
            // dirll down
            _doCombine(j + 1,n,k,curr,result);
            // reverse curr states
            curr.removeLast();
        }

    }

    public static void main(String[] args) {
        Combine combine  = new Combine();
        List<List<Integer>> combine1 = combine.combine(4, 2);
        System.out.println(Arrays.toString(combine1.toArray()));
    }
}
