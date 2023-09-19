package com.antg.leetcode.jz.jo75.simulate;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
* @author:Antg
* @create: 2023/9/18
* @Description:
 * https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/?envType=study-plan-v2&envId=coding-interviews
 * 剑指 Offer 31. 栈的压入、弹出序列
*/
public class JO_31 {
    public static void main(String[] args) {
        int[] pushed={0,2,1,3};
        int[] popped={1,2,3,0};
        System.out.println(new JO_31().validateStackSequences(pushed,popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n=pushed.length;
        for (int i = 0,j=0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
