package com.antg.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * n 皇后
 * </p>
 *
 * @author Antg
 * @since 2023/5/27 22:07
 **/
public class LC51 {
    static List<int[][]> resList = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> lists = solveNQueens(n);

        System.out.println(lists);
    }

    public static List<List<String>> solveNQueens(int n) {
        // 初始化一个二维表来模拟棋盘,0代表空位置,1代表皇后
        int[][] chessboard = new int[n][n];
        backtrack(0, chessboard);
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < resList.size(); i++) {
            int[][] arr = resList.get(i);
            List<String> tmp = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < arr[j].length; k++) {
                    if (arr[j][k] == 0) {
                        sb.append(".");
                    } else {
                        sb.append("Q");
                    }
                }
                tmp.add(sb.toString());
            }
            res.add(tmp);
        }
        return res;
    }

    public static void backtrack(int row, int[][] chessboard) {
        if (row == chessboard.length) {
            int[][] res = new int[chessboard.length][chessboard.length];
            for (int i = 0; i < chessboard.length; i++) {
                res[i] = chessboard[i].clone();
            }

            resList.add(res);
//            printChessboard(chessboard);
            return;
        }
        // 放置棋子
        for (int i = 0; i < chessboard.length; i++) {
            // 判断是否可以放置
            if (canDrop(row, i, chessboard)) {
                chessboard[row][i] = 1;// 落子
                backtrack(row + 1, chessboard); // 继续落其他棋子
                chessboard[row][i] = 0;// 回溯
            }
        }
    }

    // 判断是否可以落子
    public static boolean canDrop(int i, int j, int[][] chessboard) {
        // 位置上已经有棋子了,直接返回false
        if (chessboard[i][j] != 0) {
            return false;
        }
        // 判断横竖斜是否有棋子
        for (int ele : chessboard[i]) {
            if (ele != 0) {
                return false;
            }
        }
        for (int[] arr : chessboard) {
            if (arr[j] != 0) {
                return false;
            }
        }

        // 1,3象限 j+ i-,j- i+
        int baseI = i;
        int baseJ = j;
        while (true) {
            try {
                if (chessboard[baseI][baseJ] != 0) {
                    return false;
                }
            } catch (Exception e) {
                break;
            }
            baseI--;
            baseJ++;
//            if (baseI != 0 && baseJ != 0 && baseI != chessboard[i].length - 1 && baseJ != chessboard[i].length - 1) {
//                baseI--;
//                baseJ++;
//            } else {
//                break;
//            }
        }
        baseI = i;
        baseJ = j;
        while (true) {
            try {
                if (chessboard[baseI][baseJ] != 0) {
                    return false;
                }
            } catch (Exception e) {
                break;
            }
            baseI++;
            baseJ--;
//            if (baseI != 0 && baseJ != 0 && baseI != chessboard[i].length - 1 && baseJ != chessboard[i].length - 1) {
//                baseI++;
//                baseJ--;
//            } else {
//                break;
//            }
        }
        baseI = i;
        baseJ = j;
        // 2.4象限 j- i-,j+ i+
        while (true) {
            try {
                if (chessboard[baseI][baseJ] != 0) {
                    return false;
                }
            } catch (Exception e) {
                break;
            }
            baseI++;
            baseJ++;
//            if (baseI != 0 && baseJ != 0 && baseI != chessboard[i].length - 1 && baseJ != chessboard[i].length - 1) {
//                baseI++;
//                baseJ++;
//            } else {
//                break;
//            }
        }
        baseI = i;
        baseJ = j;
        while (true) {
            try {
                if (chessboard[baseI][baseJ] != 0) {
                    return false;
                }
            } catch (Exception e) {
                break;
            }
            baseI--;
            baseJ--;
//            if (baseI != 0 && baseJ != 0 && baseI != chessboard[i].length - 1 && baseJ != chessboard[i].length - 1) {
//                baseI--;
//                baseJ--;
//            } else {
//                break;
//            }
        }
        return true;
    }

    public static void printChessboard(int[][] chessboard) {
        for (int i = 0; i < chessboard.length; i++) {
            for (int j : chessboard[i]) {
                System.out.print(" " + j + " ");
            }
            System.out.println();
        }
        System.out.println("===========");
    }
}
