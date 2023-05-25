package com.antg.leetcode.lc;

import java.util.Arrays;

/**
 * <p>
 * 差值数组不同的字符串
 * </p>
 *
 * @author Antg
 * @since 2023/5/25 12:16
 **/
public class LC2451 {
    public static void main(String[] args) {
        String[] words = {"adc", "wzy", "abc"};
        System.out.println(oddString(words));
//        System.out.println(Character.getNumericValue('Z'));
    }

    public static String oddString(String[] words) {
        int n = words[0].length();
        int[][] wordProcessArray = new int[words.length][n - 1];
        // 遍历处理原始数组
        for (int i = 0; i < words.length; i++) {
            char[] charArray = words[i].toCharArray();
            for (int j = 0; j < charArray.length - 1; j++) {
                wordProcessArray[i][j] = charArray[j + 1] - charArray[j];
            }
        }
        // 遍历寻找不一样的
        int[] tmp = null;
        for (int i = 0; i < wordProcessArray.length; i++) {
            if (tmp != null) {
                if (!Arrays.equals(tmp, wordProcessArray[i])) {
                    return words[i];
                }
            } else {
                if (Arrays.equals(wordProcessArray[i], wordProcessArray[i + 1])) {
                    tmp = wordProcessArray[i];
                } else {
                    if (Arrays.equals(wordProcessArray[i], wordProcessArray[i + 2])) {
                        return words[i + 1];
                    } else {
                        return words[i];
                    }
                }
            }
        }
        return "";
    }
}
