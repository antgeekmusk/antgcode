package com.antg.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 二叉树的所有路径
 * </p>
 *
 * @author Antg
 * @since 2023/5/27 21:28
 **/
public class LC257 {
    static List<String> paths = new ArrayList<>();

    public static void main(String[] args) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "", paths);
        return paths;
    }

    public static void dfs(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        StringBuffer sb = new StringBuffer(path);
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(sb.toString());
        } else {
            sb.append("->");
            dfs(root.left, sb.toString(), paths);
            dfs(root.right, sb.toString(), paths);
        }
    }
}
