package com.antg.algorithm.prefix_sum;

/**
 * <p>
 * 找到最高海拔
 * </p>
 *
 * @author Antg
 * @since 2023/6/2 12:42
 **/
public class LC1732 {
    public static void main(String[] args) {
        int[] gain = {44, 32, -9, 52, 23, -50, 50, 33, -84, 47, -14, 84, 36, -62, 37, 81, -36, -85, -39, 67, -63, 64, -47, 95, 91, -40, 65, 67, 92, -28, 97, 100, 81};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for (int ele : gain) {
            sum += ele;
            if (sum >= max) {
                max = sum;
            }

        }
        return max;
    }
}
