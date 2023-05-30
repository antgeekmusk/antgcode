package com.antg.leetcode.lc;

import java.util.*;

/**
 * <p>
 * 删点成林
 * </p>
 *
 * @author Antg
 * @since 2023/5/30 10:10
 **/
public class LC1110 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        ;

        TreeNode(int val) {
            this.val = val;
        }

        ;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> delList = new HashSet<>();
        Arrays.stream(to_delete).forEach(delList::add);
        List<TreeNode> res = new ArrayList<>();
        dfs(root, true, delList, res);
        return res;

    }

    public static TreeNode dfs(TreeNode node, boolean isRoot, Set<Integer> delList, List<TreeNode> res) {
        if (node == null) {
            return null;
        }
        boolean isDel = delList.contains(node.val);
        node.left = dfs(node.left, isDel, delList, res);
        node.right = dfs(node.right, isDel, delList, res);
        if (isDel) {
            return null;
        } else {
            if (isRoot) {
                res.add(node);
            }
            return node;
        }

    }
}
