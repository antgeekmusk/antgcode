package com.antg.leetcode.jz.jo75.find;
/**
* @author:Antg
* @create: 2023/9/22
* @Description:
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
*/
public class LC_153 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(new LC_153().findMin(nums));
    }
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        while (low<high){
            int mid=(low+high)/2;
            if(nums[mid]<nums[high]){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return nums[low];
    }
}
