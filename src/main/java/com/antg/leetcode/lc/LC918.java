package com.antg.leetcode.lc;
/**
* @author:Antg
* @create: 2023/7/20
* @Description: 918. 环形子数组的最大和
*/
public class LC918 {
    public static void main(String[] args) {
        int[] nums = {5,5,0,-5,3,-3,2};
        System.out.println(maxSubarraySumCircular2(nums));
    }
    /**
    * @author:Antg
    * @create: 2023/7/20
    * @Description: 暴力破解,会超时,得优化一下
    */
    public static int maxSubarraySumCircular(int[] nums) {
        int res=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp=0;
            for(int j=i,cnt=0;cnt< nums.length;j=(j+1)%nums.length,cnt++){
                tmp+=nums[j];
                if(tmp>res){
                    res=tmp;
                }
            }


        }
        return res;
        
    }

    public static int maxSubarraySumCircular2(int[] nums) {
        int maxS = Integer.MIN_VALUE; // 最大子数组和，不能为空
        int minS = 0; // 最小子数组和，可以为空
        int maxF = 0, minF = 0, sum = 0;
        for (int x : nums) {
            // 以 nums[i-1] 结尾的子数组选或不选（取 max）+ x = 以 x 结尾的最大子数组和
            maxF = Math.max(maxF, 0) + x;
            maxS = Math.max(maxS, maxF);
            // 以 nums[i-1] 结尾的子数组选或不选（取 min）+ x = 以 x 结尾的最小子数组和
            minF = Math.min(minF, 0) + x;
            minS = Math.min(minS, minF);
            sum += x;
        }
        return sum == minS ? maxS : Math.max(maxS, sum - minS);

    }
}
