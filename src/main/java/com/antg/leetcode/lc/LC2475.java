package com.antg.leetcode.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 数组中不等三元组的数目
 * </p>
 *
 * @author Antg
 * @since 2023/6/13 09:57
 **/
public class LC2475 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 4};
        System.out.println(unequalTriplets(nums));

    }

    /**
     * @author Antg
     * @description
     * @time 2023/6/13 11:12
     **/
    public static int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int res = 0, n = nums.length, t = 0;
        for (Map.Entry<Integer, Integer> ele : map.entrySet()) {
            res += t * ele.getValue() * (n - t - ele.getValue());
            t += ele.getValue();
        }
        return res;
    }
}
