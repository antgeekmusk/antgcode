package com.antg.leetcode.jz;

/**
 * <p>
 * 左右两边子数组的和相等
 * </p>
 *
 * @author Antg
 * @since 2023/6/2 12:11
 **/
public class JO2_012 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        // 前缀和和后缀和,0的位置前缀和,1的位置后缀和
        int[][] sum = new int[nums.length + 1][2];
        for (int i = 0; i < nums.length; i++) {
            // 前缀和
            sum[i + 1][0] = sum[i][0] + nums[i];
            // 后缀和
            sum[nums.length - i - 1][1] = sum[nums.length - i][1] + nums[nums.length - i - 1];
        }
        for (int i = 0; i < sum.length - 1; i++) {
            if (sum[i][0] == sum[i + 1][1]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @author Antg
     * @description 0毫秒
     * @time 2023/6/2 12:32
     **/
    public static int pivotIndex2(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 左右两边相等
            if (sum == (total - sum - nums[i])) {
                return i;
            }
            sum += nums[i];
        }
        return -1;

    }
}
