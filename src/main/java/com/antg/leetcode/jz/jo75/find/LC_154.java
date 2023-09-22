package com.antg.leetcode.jz.jo75.find;
/**
* @author:Antg
* @create: 2023/9/22
* @Description:
 * 154. 寻找旋转排序数组中的最小值 II
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/description/
*/
public class LC_154 {
    public static void main(String[] args) {

    }
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        while (low<high){
            int mid=(low+high)/2;
            if(nums[mid]<nums[high]){
                high=mid;
            } else if (nums[mid]>nums[high]) {
                low=mid+1;
            }else{
                high-=1;
            }
        }
        return nums[low];
    }
}
