package com.antg.leetcode.jz.jo75.search_backtrack;
/**
 * <p>
 *  LCR 144. 翻转二叉树
 *  https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/?envType=study-plan-v2&envId=coding-interviews
 * </p>
 * @author Antg
 * @since  2023/9/28 20:27
 **/
public class JO_144 {
    public TreeNode mirrorTree(TreeNode root) {
        reverse(root);
        return root;
    }

    // 翻转
    public void reverse(TreeNode root){
        if(root==null) return;
        TreeNode tmp = root.right;
        root.right=root.left;
        root.left=tmp;
        reverse(root.left);
        reverse(root.right);
    }

    /**
     * <p>
     *  只用一个函数
     * </p>
     * @author Antg
     * @since  2023/9/28 20:34
     **/
    public TreeNode mirrorTree2(TreeNode root) {
        if(root==null) return null;
        TreeNode tmp = root.left;
        root.left=mirrorTree2(root.right);
        root.right=mirrorTree2(tmp);
        return root;
    }
}
