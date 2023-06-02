package com.antg.leetcode.lc;

/**
 * <p>
 * 一维数组的动态和
 * </p>
 *
 * @author Antg
 * @since 2023/6/2 12:38
 **/
public class LC1480 {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }
}
