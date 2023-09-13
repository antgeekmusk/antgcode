package com.antg.leetcode.jz.jo75.stack_queue;

import java.util.Stack;

/**
* @author:Antg
* @create: 2023/9/9
* @Description:
 * 剑指 Offer 30. 包含min函数的栈
 * https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/description/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_30 {


    /**
    * @author:Antg
    * @create: 2023/9/9
    * @Description: 辅助栈
    */
    static class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;


        /** initialize your data structure here. */
        public MinStack() {
            stack=new Stack<>();
            minStack=new Stack<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            minStack.push(Math.min(x,minStack.peek()));
        }

        public void pop() {
            stack.pop();
            minStack.pop();


        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
    /**
    * @author:Antg
    * @create: 2023/9/9
    * @Description: 双压双弹法
    */
    static class MinStack2 {
        Stack<Integer> stack;
        int min;
        public MinStack2() {
            stack=new Stack<>();
            min=Integer.MAX_VALUE;
        }
        public void push(int x) {
            if(x<=min){
                stack.push(min);
                min=x;
            }
            stack.push(x);
        }
        public void pop() {
            if(stack.pop()==min){
                min=stack.pop();
            }
        }
        public int top() {
            return stack.peek();
        }
        public int min() {
            return min;
        }
    }
    /**
    * @author:Antg
    * @create: 2023/9/9
    * @Description: 差值法
     *
    */
    static class MinStack3 {
        Stack<Long> stack;
        long min;
        public MinStack3() {
            stack=new Stack<>();
            min=Integer.MAX_VALUE;
        }
        public void push(int x) {
            if(stack.isEmpty()){
                stack.push((long)0);
                min=x;
            }else {
                long diff = x - min;
                stack.push(diff);
                if (diff < 0) min = x;
            }
        }
        public void pop() {
            long popVal = stack.pop();
            if(popVal<0){
                min=min-popVal;
            }

        }
        public int top() {
            if(stack.peek()>=0){
                return (int)(min+stack.peek());
            }else{
                return (int)min;
            }
        }
        public int min() {return (int)min;}

    }

}
