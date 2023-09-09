package com.antg.leetcode.jz.jo75.stack_queue;

import java.util.Stack;

/**
* @author:Antg
* @create: 2023/9/9
* @Description:
 * 剑指 Offer 09. 用两个栈实现队列
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_09 {

    /**
    * @author:Antg
    * @create: 2023/9/9
    * @Description:
     * 使用两个栈来实现队列
    */
    static class CQueue {
        Stack<Integer> a,b;

        public CQueue() {
            a=new Stack<>();
            b=new Stack<>();
        }

        public void appendTail(int value) {
            a.push(value);
        }

        public int deleteHead() {
            if(!b.isEmpty()){
                return b.pop();
            }
            if(a.isEmpty()){
                return -1;
            }
            while (!a.isEmpty()){
                b.push(a.pop());
            }
            return b.pop();
        }
    }
}
