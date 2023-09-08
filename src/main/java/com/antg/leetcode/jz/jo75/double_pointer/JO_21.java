package com.antg.leetcode.jz.jo75.double_pointer;
/**
* @author:Antg
* @create: 2023/9/8
* @Description:
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_21 {
    /**
    * @author:Antg
    * @create: 2023/9/8
    * @Description:
     * 双指针,奇数从前往后存储,偶数从后往前存储
    */
    public int[] exchange(int[] nums) {
        int res[] = new int[nums.length];
        int front=0;
        int back=nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==0){
                res[back]=nums[i];
                back--;
            }else{
                res[front]=nums[i];
                front++;
            }
        }
        return res;
    }

    /**
    * @author:Antg
    * @create: 2023/9/8
    * @Description: 原地交换
    */
    public int[] exchange2(int[] nums) {
        int left=0,right=nums.length-1;
        while (left<right){
            while (left<right && nums[left]%2==1){
                left++;
            }
            while (left<right && nums[right]%2==0){
                right--;
            }
            if(left<right){
                int tmp=nums[left];
                nums[left]=nums[right];
                nums[right]=tmp;
                left++;
                right--;
            }
        }
        return nums;
    }

}
