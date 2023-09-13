package com.antg.leetcode.jz.jo75.stack_queue;

import java.util.*;

/**
* @author:Antg
* @create: 2023/9/11
* @Description:
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_59 {
    public static void main(String[] args) {
        int[] nums={7,2,4};
        int k=2;
        int[] ints = new JO_59().maxSlidingWindow3(nums, k);
        for (int ele : ints) {
            System.out.println(ele);
        }

    }

    /**
    * @author:Antg
    * @create: 2023/9/11
    * @Description: 暴力遍历 可行,但是会超时,需要优化一下
     *
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1) return nums;
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i <= nums.length-k; i++) {
            res[i]=getRangeMaxNumber2(nums, i, i + k-1);
        }
        return res;
    }

    public int getRangeMaxNumber(int[] nums,int start,int end){
        int max=Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if(nums[i]>max){
                max=nums[i];
            }
        }
        return max;
    }
    /**
    * @author:Antg
    * @create: 2023/9/11
    * @Description:
     * 如果end端出现比上一个最大值大的,直接更新成nums[end]即可
     * 如果start端=当前最大的值,那么下一次就需要进行全局扫描,然后更新当前最大值
     *
     * 还是不行,比之前的强点了,但是还是会超时
    */
    int currentMax=Integer.MIN_VALUE;
    boolean nextFullScan=false;
    boolean firstFullScan=true;
    public int getRangeMaxNumber2(int[] nums,int start,int end){
        if(nextFullScan || firstFullScan){
            int max=Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                if(nums[i]>max){
                    max=nums[i];
                }
            }
            currentMax=max;
            firstFullScan=false;
            if(nums[start]<=currentMax){
                nextFullScan=true;
            }
        }else{
            if(nums[end]>currentMax){
                currentMax=nums[end];
            }
        }
        return currentMax;
    }

    /**
    * @author:Antg
    * @create: 2023/9/12
    * @Description: 使用优先级队列 PriorityQueue
    */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        // 创建优先队列
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0]!=o2[0]?o2[0]-o1[0]:o2[1]-o1[1];// 返回值为负数 o1排在o2前面
        });

        // 初始化入队
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i],i});
        }
        int res[] = new int[nums.length-k+1];
        res[0]=pq.peek()[0];

        //遍历剩下的值
        for (int i = k; i < nums.length; i++) {
            pq.offer(new int[]{nums[i],i});
            // 如果顶部最大值是无效的(左端及左端前面的值),去除
            while (pq.peek()[1]<=i-k){
                pq.poll();
            }
            res[i-k+1]=pq.peek()[0];
        }
        return res;
    }
    
    /**
    * @author:Antg
    * @create: 2023/9/12
    * @Description: 单调队列
    */
    
    
    /**
    * @author:Antg
    * @create: 2023/9/12
    * @Description: 分块+预处理
    */

}
