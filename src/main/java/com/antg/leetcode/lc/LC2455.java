package com.antg.leetcode.lc;

import java.util.Arrays;

/**
 * <p>
 * 可被三整除的偶数的平均值
 * </p>
 *
 * @author Antg
 * @since 2023/5/29 23:42
 **/
public class LC2455 {
    public static void main(String[] args) {

    }

    public static int averageValue(int[] nums) {
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 == 0 && nums[i] % 2 == 0) {
                sum += nums[i];
                cnt++;
            }
        }
        return (int) Math.floor((double) sum / cnt);
    }

    public static int averageValue2(int[] nums) {
        return (int) Arrays.stream(nums).filter(x -> x % 6 == 0).average().orElse(0);
    }
}
