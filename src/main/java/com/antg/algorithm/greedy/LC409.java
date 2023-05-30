package com.antg.algorithm.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 最长子回文串
 * </p>
 *
 * @author Antg
 * @since 2023/5/30 10:36
 **/
public class LC409 {
    public static void main(String[] args) {
        String s = "bb";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        // 统计字符串中每个字符出现的次数,最后构建的回文串只能有一个奇数,多个偶数,也就是最长的话就是所有的偶数加起来,然后加上最长的那个奇数
        Map<Character, Integer> container = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (container.containsKey(arr[i])) {
                container.put(arr[i], container.get(arr[i]) + 1);
            } else {
                container.put(arr[i], 1);
            }
        }
        int cnt = 0;
        boolean haveOdd = false;
        for (Character ele : container.keySet()) {
            Integer n = container.get(ele);
            if (n % 2 == 0) {
                cnt += n;
            } else {
                cnt += n - 1;
                haveOdd = true;
            }
        }

        return (haveOdd ? 1 : 0) + cnt;

    }
}
