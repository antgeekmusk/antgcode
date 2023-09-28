package com.antg.leetcode.jz.jo75.search_backtrack;
/**
 * <p>
 *  LCR 143. 子结构判断
 *  https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/?envType=study-plan-v2&envId=coding-interviews
 * </p>
 * @author Antg
 * @since  2023/9/28 20:01
 **/
public class JO_143 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null && B!=null) &&(recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }

    // 判断b是否是a的子树
    public boolean recur(TreeNode a,TreeNode b){
        if(b==null) return true;
        if(a==null || a.val!=b.val) return false;
        return recur(a.left,b.left) && recur(a.right,b.right);
    }
}
