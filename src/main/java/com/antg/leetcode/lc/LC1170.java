package com.antg.leetcode.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 比较字符串最小字母出现频次
 * </p>
 *
 * @author Antg
 * @since 2023/6/10 08:07
 **/
public class LC1170 {
    public static void main(String[] args) {
        String[] queries = {"bba", "abaaaaaa", "aaaaaa", "bbabbabaab", "aba", "aa", "baab", "bbbbbb", "aab", "bbabbaabb"};
//        String[] words = {"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"};
//        int[] ints = numSmallerByFrequency(queries, words);
//        for (int ele : ints) {
//            System.out.println(ele);
//        }
        for (String ele : queries) {
            System.out.println(f(ele));
        }
    }

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        // 将两个数组进行转换
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            q[i] = f(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            w[i] = f(words[i]);
        }
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < w.length; j++) {
                if (q[i] < w[j]) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    public static int f(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        char min = arr[0];
        for (char c : arr) {
            if (c <= min) {
                min = c;
            }
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map.get(min);
    }
}
