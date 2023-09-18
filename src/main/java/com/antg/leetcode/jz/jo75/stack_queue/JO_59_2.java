package com.antg.leetcode.jz.jo75.stack_queue;
/**
* @author:Antg
* @create: 2023/9/15
* @Description:
 * 剑指 Offer 59 - II. 队列的最大值
 * https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_59_2 {
    public static void main(String[] args) {

    }

    /**
    * @author:Antg
    * @create: 2023/9/15
    * @Description: 暴力
    */
    static class MaxQueue {
        int q[] = new int[20000];
        int begin=0,end=0;
        public MaxQueue() {

        }

        public int max_value() {
            int max=-1;
            for (int i = begin; i <end ; i++) {
                max=Math.max(q[i],max);
            }
            return max;
        }

        public void push_back(int value) {
            q[end++]=value;
        }

        public int pop_front() {
            if(begin==end){
                return -1;
            }
            return q[begin++];
        }
    }

}
