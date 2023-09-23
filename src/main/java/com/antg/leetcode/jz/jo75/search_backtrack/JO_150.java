package com.antg.leetcode.jz.jo75.search_backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
* @author:Antg
* @create: 2023/9/23
* @Description:
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/?envType=study-plan-v2&envId=coding-interviews
 * LCR 150. 彩灯装饰记录 II
*/
public class JO_150 {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        while (!cur.isEmpty()){
            List<TreeNode> next = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            for (TreeNode treeNode : cur) {
                tmp.add(treeNode.val);
                if(treeNode.left!=null) next.add(treeNode.left);
                if(treeNode.right!=null) next.add(treeNode.right);
            }
            res.add(tmp);
            cur=next;
        }
        return res;
    }

    /**
    * @author:Antg
    * @create: 2023/9/23
    * @Description:
     * 使用队列
    */
    public List<List<Integer>> decorateRecord2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for(int i=queue.size();i>0;i--){
                TreeNode poll = queue.poll();
                tmp.add(poll.val);
                if(poll.left!=null) queue.add(poll.left);
                if(poll.right!=null) queue.add(poll.right);
            }
            res.add(tmp);
        }
        return res;
    }

}
