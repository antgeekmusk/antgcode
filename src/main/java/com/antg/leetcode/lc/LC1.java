package com.antg.leetcode.lc;

import java.util.HashMap;

/**
 * <p>
 * 两数之和
 * </p>
 *
 * @author Antg
 * @since 2023/5/25 13:01
 **/
public class LC1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(nums, target));
    }

    /**
     * @author Antg
     * @description 双层for循环
     * @time 2023/5/25 13:09
     **/
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * @author Antg
     * @description 哈希
     * @time 2023/5/25 13:10
     **/
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


}
