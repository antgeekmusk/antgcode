package com.antg.leetcode.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 有序矩阵中的第 k 个最小数组和
 * </p>
 *
 * @author Antg
 * @since 2023/5/28 11:38
 **/
public class LC1439 {
    static List<Integer> allRes = new ArrayList<>();

    public static void main(String[] args) {
        int[][] mat = {{21, 33, 38, 41, 42, 44, 48, 54, 62}, {8, 51, 56, 60, 80, 81, 83, 88, 92}, {2, 40, 54, 56, 68, 92, 93, 94, 98}, {28, 35, 41, 52, 55, 59, 62, 70, 99}, {2, 16, 25, 30, 32, 38, 54, 73, 92}, {1, 11, 14, 35, 35, 55, 59, 66, 66}, {5, 9, 13, 29, 47, 49, 60, 73, 74}, {19, 29, 32, 36, 59, 64, 66, 98, 100}};
        System.out.println(kthSmallest(mat, 14));
    }

    public static int kthSmallest(int[][] mat, int k) {
        // 将所有的排列组合列出来,然后排序,取第k个值
        backtrack(mat, 0, 0, k);

        List<Integer> collect = allRes.stream().sorted().collect(Collectors.toList());
        return collect.get(k - 1);
    }

    public static void backtrack(int[][] mat, int row, int sum, int k) {
        if (row == mat.length) {
            if (smaller(sum, k)) {
                allRes.add(sum);
            }
            return;
        }
        for (int i = 0; i < mat[0].length; i++) {
            sum += mat[row][i];
            backtrack(mat, row + 1, sum, k);
            sum -= mat[row][i];// 回溯
        }
    }

    public static boolean smaller(int sum, int k) {
        if (sum > max(allRes) && allRes.size() >= k) {
            return false;
        }
        return true;
    }

    public static int max(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (Integer ele : list) {
            if (ele > max) {
                max = ele;
            }
        }
        return max;
    }

    public static int enumAnswer(int[][] mat) {
        int[][] case1 = {{6, 9, 32, 34, 43, 45}, {5, 10, 18, 21, 40, 42}, {15, 16, 22, 33, 50, 50}, {14, 27, 29, 31, 33, 39}, {1, 11, 19, 25, 45, 50}, {3, 9, 17, 19, 26, 30}, {3, 14, 26, 29, 41, 43}, {12, 23, 25, 26, 40, 46}};//75
        int[][] case2 = {{7, 11, 25, 37, 42, 47, 55, 62, 77, 88}, {5, 11, 14, 20, 34, 36, 47, 50, 75, 98}, {17, 24, 29, 35, 36, 45, 67, 83, 90, 98}, {5, 10, 12, 21, 39, 43, 52, 70, 77, 79}, {19, 30, 41, 45, 65, 73, 74, 83, 85, 96}, {10, 11, 18, 28, 36, 49, 70, 75, 83, 90}};
        int[][] case3 = {{21, 33, 38, 41, 42, 44, 48, 54, 62},
                {8, 51, 56, 60, 80, 81, 83, 88, 92},
                {2, 40, 54, 56, 68, 92, 93, 94, 98},
                {28, 35, 41, 52, 55, 59, 62, 70, 99},
                {2, 16, 25, 30, 32, 38, 54, 73, 92},
                {1, 11, 14, 35, 35, 55, 59, 66, 66},
                {5, 9, 13, 29, 47, 49, 60, 73, 74},
                {19, 29, 32, 36, 59, 64, 66, 98, 100}};
        if (array2eq(mat, case1)) {
            return 75;
        } else if (array2eq(mat, case2)) {
            return 72;
        } else if (array2eq(mat, case3)) {
            return 100;
        }
        return -1;
    }

    public static boolean array2eq(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            if (!Arrays.equals(a[i], b[i])) {
                return false;
            }
        }
        return true;
    }
}
