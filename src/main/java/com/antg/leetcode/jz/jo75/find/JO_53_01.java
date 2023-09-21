package com.antg.leetcode.jz.jo75.find;
/**
* @author:Antg
* @create: 2023/9/19
* @Description:
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_53_01 {
    public static void main(String[] args) {
        int[] nums={1,2,3,3,3,4,5};
        System.out.println(new JO_53_01().binarySearch(nums,3,false));
    }

    public int search(int[] nums, int target) {
        // 采用二分查找先找到第一个target 的下表
        int bi = binarySearch(nums, target);
        if(bi==-1) return 0;
        int res=0;
        for (int i = bi; i < nums.length; i++) {
            if(nums[i]==target){
                res++;
            }
        }
        return res;
    }

    public int binarySearch(int[] nums, int target){
        int low=0;
        int high=nums.length-1;

        while (low<=high){
            int middle=(low+high)/2;
            if(target==nums[middle]){
                // 向左找到第一个等于的index
                int tmp=middle;
                while (true){
                    tmp--;
                    if(tmp<0) return 0;
                    if(target!=nums[tmp]){
                        return ++tmp;
                    }

                }
            }else if(target>nums[middle]){
                low=middle+1;
            }else{
                high=middle-1;
            }
        }
        return -1;

    }


    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
