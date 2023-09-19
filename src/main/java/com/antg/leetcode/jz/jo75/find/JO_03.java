package com.antg.leetcode.jz.jo75.find;

import java.util.HashSet;
import java.util.Set;

/**
* @author:Antg
* @create: 2023/9/19
* @Description:
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/?envType=study-plan-v2&envId=coding-interviews
 * 剑指 Offer 03. 数组中重复的数字
*/
public class JO_03 {
    /**
    * @author:Antg
    * @create: 2023/9/19
    * @Description: hashset 法
    */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                return num;
            }else {
                set.add(num);
            }
        }

        return -1;
    }
    /**
    * @author:Antg
    * @create: 2023/9/19
    * @Description: 原地交换
    */
    public int findRepeatNumber2(int[] nums) {
        int i=0;
        while (i<nums.length){
            if(nums[i]==i){
                i++;
                continue;
            }
            if(nums[i]==nums[nums[i]]) return nums[i];
            int tmp=nums[i];
            nums[i]=nums[tmp];
            nums[tmp]=tmp;

        }
        return -1;

    }
}
