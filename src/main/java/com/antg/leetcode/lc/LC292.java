package com.antg.leetcode.lc;

/**
 * <p>
 * Nim 游戏
 * 巴什博弈 n/(m+1) 后手必胜
 * </p>
 *
 * @author Antg
 * @since 2023/5/28 17:10
 **/
public class LC292 {
    static boolean res = false;

    public static void main(String[] args) {
        System.out.println(canWinNim(4));
    }

    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
