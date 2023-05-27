package com.antg.leetcode.lc;

/**
 * <p>
 * 大样本统计
 * </p>
 *
 * @author Antg
 * @since 2023/5/27 19:54
 **/
public class LC1093 {
    public static void main(String[] args) {
        int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3510, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6718, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 27870, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26256, 0, 0, 0, 0, 9586565, 0, 0, 0, 0, 0, 0, 0, 2333, 0, 0, 0, 0};
        double[] doubles = sampleStats(count);
        for (double aDouble : doubles) {
            System.out.println(aDouble);
        }

    }

    public static double[] sampleStats(int[] count) {
        // 总和
        double sum = 0;
        // 数字格式
        int sumCnt = 0;
        // 求最大值
        double max = 0;
        // 求最小值
        double min = 0;
        // 均值
        double mean = 0;
        // 中位数
        double median = 0;
        // 众数
        double mode = 0;
        double modeNum = 0;
        for (int i = 0; i < count.length; i++) {
            // 最大
            if (count[i] > 0) {
                max = i;
            }
            // 最小
            if (count[count.length - i - 1] > 0) {
                min = count.length - i - 1;
            }
            // 和
            // 这里需要注意,i*count[i] 的时候可能会整数溢出,所以将某个值转成double再计算
            sum = sum + (double) i * count[i];
            sumCnt = sumCnt + count[i];
            // 众数
            if (count[i] > modeNum) {
                modeNum = count[i];
                mode = i;
            }
        }
        mean = sum / sumCnt;
        // 求中位数

        if (sumCnt % 2 != 0) {
            int tmp = (sumCnt - 1) / 2;
            double before = 0;
            for (int i = 0; i < count.length; i++) {
                if (tmp < 0) {
                    median = before;
                    break;
                }
                if (tmp == 0 && count[i] > 0) {
                    median = i;
                    break;
                }
                tmp = tmp - count[i];
                if (count[i] > 0) {
                    before = i;
                }
            }
        } else {
            int tmp = sumCnt / 2;
            double before = 0;
            for (int i = 0; i < count.length; i++) {
                if (tmp == 0 && count[i] > 0) {
                    median = (i + before) / 2;
                    break;
                }
                if (tmp < 0) {
                    median = before;
                    break;
                }
                tmp = tmp - count[i];
                if (count[i] > 0) {
                    before = i;
                }
            }
        }

        return new double[]{min, max, mean, median, mode};
    }
}
