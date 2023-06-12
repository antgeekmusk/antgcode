package com.antg.leetcode.lc;

import java.util.Arrays;

/**
 * <p>
 * 树节点的第 K 个祖先
 * </p>
 *
 * @author Antg
 * @since 2023/6/12 09:57
 **/
public class LC1483 {
    public static void main(String[] args) {

    }


    /**
     * @author Antg
     * @description 倍增 求LCA 经典
     * @time 2023/6/12 09:59
     **/
    static class TreeAncestor {
        static final int LOG = 16;
        int[][] ancestors;

        public TreeAncestor(int n, int[] parent) {
            ancestors = new int[n][LOG];
            for (int i = 0; i < n; i++) {
                Arrays.fill(ancestors[i], -1);
            }
            for (int i = 0; i < n; i++) {
                ancestors[i][0] = parent[i];
            }
            for (int j = 1; j < LOG; j++) {
                for (int i = 0; i < n; i++) {
                    if (ancestors[i][j - 1] != -1) {
                        ancestors[i][j] = ancestors[ancestors[i][j - 1]][j - 1];
                    }
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            for (int j = 0; j < LOG; j++) {
                if (((k >> j) & 1) != 0) {
                    node = ancestors[node][j];
                    if (node == -1) {
                        return -1;
                    }
                }
            }
            return node;
        }
    }
}


