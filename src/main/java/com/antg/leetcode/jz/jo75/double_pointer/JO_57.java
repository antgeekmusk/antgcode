package com.antg.leetcode.jz.jo75.double_pointer;

import java.util.HashMap;
import java.util.Map;

/**
* @author:Antg
* @create: 2023/9/8
* @Description:
 * 剑指 Offer 57. 和为s的两个数字
 * https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_57 {
    /**
    * @author:Antg
    * @create: 2023/9/8
    * @Description: hashmap 解法
    */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target-nums[i],nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{nums[i],map.get(nums[i])};
            }
        }
        return null;
    }
    /**
    * @author:Antg
    * @create: 2023/9/8
    * @Description: 因为数组是有序的,可以使用更优解
     * 双指针解法
    */
    public int[] twoSum2(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<right){
            int s = nums[left]+nums[right];
            if(s>target){
                right--;
            } else if (s<target) {
                left++;
            }else {
                return new int[]{nums[left],nums[right]};
            }
        }
        return null;
    }




}
