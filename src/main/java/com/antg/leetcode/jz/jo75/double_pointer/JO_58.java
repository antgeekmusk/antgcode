package com.antg.leetcode.jz.jo75.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author:Antg
* @create: 2023/9/9
* @Description:
 * 剑指 Offer 58 - I. 翻转单词顺序
 * https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_58 {
    public static void main(String[] args) {
        String a="a good   example";
        String[] s = a.trim().split(" ");
        for (String s1 : s) {
            System.out.println(s1);
        }
    }

    /**
    * @author:Antg
    * @create: 2023/9/9
    * @Description: 方法一 使用语言特性
    */
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        for (int i = 0; i < arr.length/2; i++) {
            String tmp = arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=tmp;

        }
        return String.join(" ",arr);
    }

}
