package com.antg.leetcode.jz.jo75.str;
/**
* @author:Antg
* @create: 2023/8/1
* @Description:
 * 左旋转字符串
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO2_58 {
    public static void main(String[] args) {
        System.out.println("abcd".substring(0,2));
        System.out.println("abcd".substring(2,4));
    }
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n,s.length())+s.substring(0,n);
    }
}
