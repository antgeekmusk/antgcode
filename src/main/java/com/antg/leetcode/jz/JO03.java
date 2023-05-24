package com.antg.leetcode.jz;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 剑指 Offer 03. 数组中重复的数字
 * </p>
 *
 * @author Antg
 * @since 2023/5/24 17:44
 **/
public class JO03 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 1, 1, 0};
        int res1 = m1(nums);
        System.out.println(res1);
        int res2 = m2(nums);
        System.out.println(res2);
    }


    /**
     * @author Antg
     * @description 双层for循环
     * @time 2023/5/24 17:53
     **/
    public static int m1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static int m2(int[] nums) {
        Set<Integer> dic = new HashSet<>();
        for (int num : nums) {
            if (dic.contains(num)) {
                return num;
            }
            dic.add(num);
        }
        return -1;
    }
}
