package com.antg.algorithm.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 回溯算法 : 二进制手表
 * </p>
 *
 * @author Antg
 * @since 2023/5/25 13:26
 **/
public class LC401 {

    static int[] hours = new int[]{1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
    static int[] minutes = new int[]{0, 0, 0, 0, 1, 2, 4, 8, 16, 32};
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(readBinaryWatch3(3));
    }

    /**
     * @author Antg
     * @description 枚举法 1
     * @time 2023/5/25 13:54
     **/
    public static List<String> readBinaryWatch(int turnedOn) {
        Map<Integer, List<String>> dic = new HashMap<>();
        for (int i = 0; i <= 11; i++) {
            dic.put(i, new ArrayList<>());
        }

        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 59; j++) {
                //拼接一个时间
                int[] time = {i, j};
                // 根据时间获得二级制手表量多少灯
                int key = Integer.toBinaryString(i).replace("0", "").length() + Integer.toBinaryString(j).replace("0", "").length();

                // 将结果存储在map中
                List<String> value = dic.get(key);
                value.add(String.valueOf(i) + ":" + (j <= 9 ? "0" + String.valueOf(j) : String.valueOf(j)));
                dic.put(key, value);
            }
        }
        return dic.get(turnedOn);
    }

    /**
     * @author Antg
     * @description 枚举法2
     * @time 2023/5/25 15:13
     **/
    public static List<String> readBinaryWatch2(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {

            for (int j = 0; j < 60; j++) {
                int cnt = Integer.bitCount(i) + Integer.bitCount(j);
                if (turnedOn == cnt) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i).append(":");
                    if (j < 10) {
                        sb.append("0");
                    }
                    sb.append(j);
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }

    /**
     * @author Antg
     * @description 回溯法
     * @time 2023/5/27 19:19
     **/

    public static List<String> readBinaryWatch3(int turnedOn) {
        backtrack(turnedOn, 0, 0, 0);
        return res;
    }

    public static void backtrack(int num, int index, int hour, int minute) {
        if (hour > 11 || minute > 59)
            return;
        if (num == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(':');
            if (minute < 10) {
                sb.append('0');
            }
            sb.append(minute);
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < 10; i++) {
            backtrack(num - 1, i + 1, hour + hours[i], minute + minutes[i]);
        }
    }


}
