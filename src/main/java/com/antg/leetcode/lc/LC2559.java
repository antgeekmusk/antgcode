package com.antg.leetcode.lc;

import java.util.Arrays;

/**
 * <p>
 * 统计范围内的元音字符串数
 * </p>
 *
 * @author Antg
 * @since 2023/6/2 10:42
 **/
public class LC2559 {
    public static void main(String[] args) {
        String[] words = {"a", "e", "i"};
        int[][] queries = {{0, 2}, {0, 1}, {2, 2}};
        Arrays.stream(vowelStrings(words, queries)).forEach(System.out::println);

    }

    /**
     * @author Antg
     * @description 暴力破解会导致运行超时, 所以正解是用 前缀和
     * @time 2023/6/2 11:55
     **/
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            for (int j = query[0]; j <= query[1] && j < words.length; j++) {
                if (check(words[j])) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    public static int[] vowelStrings2(String[] words, int[][] queries) {
        // 构建前缀和
        int[] prefixSum = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            if (check(words[i])) {
                prefixSum[i + 1] = prefixSum[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i];
            }
        }

        // 结果
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = prefixSum[queries[i][1] + 1] - prefixSum[queries[i][0]];
        }
        return res;

    }


    public static boolean check(String word) {
        char[] y = {'a', 'e', 'i', 'o', 'u'};
        char[] charArray = word.toCharArray();
        char head = charArray[0];
        boolean headFlag = false;
        char tail = charArray[charArray.length - 1];
        boolean tailFlag = false;
        for (char c : y) {
            if (head == c) {
                headFlag = true;
            }
            if (tail == c) {
                tailFlag = true;
            }
        }
        return headFlag && tailFlag;
    }
}
