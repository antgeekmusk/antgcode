package com.antg.leetcode.lc;

/**
 * <p>
 * 2391. 收集垃圾的最少总时间
 * </p>
 *
 * @author Antg
 * @since 2023/5/24 18:22
 **/
public class LC2391 {
    public static void main(String[] args) {
        String[] garbage = {"G", "M", "P"};
        int[] travel = {1, 3};
        System.out.println(garbageCollection(garbage, travel));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        // 寻找每种垃圾最后出现的位置
        int maxM = 0;
        int maxP = 0;
        int maxG = 0;
        for (int i = 0; i < garbage.length; i++) {
            if (garbage[i].contains("M")) {
                maxM = i;
            }
            if (garbage[i].contains("P")) {
                maxP = i;
            }
            if (garbage[i].contains("G")) {
                maxG = i;
            }
        }

        // 开始遍历寻找
        int mTime = 0;
        int pTime = 0;
        int gTime = 0;
        int[][] garbageProcess = new int[garbage.length][3];
        for (int i = 0; i < garbage.length; i++) {
            int[] typeCnt = getTypeCnt(garbage[i]);
            garbageProcess[i] = typeCnt;
        }
        for (int i = 0; i < garbageProcess.length; i++) {
            if (i <= maxM) {
                mTime = mTime + (garbageProcess[i][0] != 0 ? garbageProcess[i][0] : 0) + (i > 0 ? travel[i - 1] : 0);
            }
            if (i <= maxP) {
                pTime = pTime + (garbageProcess[i][1] != 0 ? garbageProcess[i][1] : 0) + (i > 0 ? travel[i - 1] : 0);
            }
            if (i <= maxG) {
                gTime = gTime + (garbageProcess[i][2] != 0 ? garbageProcess[i][2] : 0) + (i > 0 ? travel[i - 1] : 0);
            }
        }


        return mTime + pTime + gTime;
    }

    /**
     * @author Antg
     * @description 字符串str中出现了多少次mpg
     * @time 2023/5/24 18:29
     **/
    public static int[] getTypeCnt(String str) {
        char[] charArray = str.toCharArray();
        // m,p,g
        int res[] = {0, 0, 0};
        for (int i = 0; i < charArray.length; i++) {
            if ('M' == charArray[i]) {
                res[0]++;
            } else if ('P' == charArray[i]) {
                res[1]++;
            } else {
                res[2]++;
            }
        }
        return res;
    }
}
