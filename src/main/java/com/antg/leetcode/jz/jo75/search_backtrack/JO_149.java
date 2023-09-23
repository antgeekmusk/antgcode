package com.antg.leetcode.jz.jo75.search_backtrack;

import com.antg.leetcode.jz.jo75.find.LC_153;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
* @author:Antg
* @create: 2023/9/23
* @Description:
 * LCR 149. 彩灯装饰记录 I
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_149 {
    /**
    * @author:Antg
    * @create: 2023/9/23
    * @Description: 使用队列实现BFS 广度优先遍历
    */
    public int[] decorateRecord(TreeNode root) {
        if(root==null) return new int[0];
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            res.add(poll.val);
            if(poll.left!=null) queue.add(poll.left);
            if(poll.right!=null) queue.add(poll.right);
        }
        int list[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            list[i]=res.get(i);
        }
        return list;
    }

    /**
    * @author:Antg
    * @create: 2023/9/23
    * @Description: 使用两个数组实现
     *
    */
    public int[] decorateRecord2(TreeNode root) {
        if(root==null) return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> current = new ArrayList<>();
        current.add(root);
        while (!current.isEmpty()){
            ArrayList<TreeNode> next = new ArrayList<>();
            for (TreeNode treeNode : current) {
                list.add(treeNode.val);
                if(treeNode.left!=null) next.add(treeNode.left);
                if(treeNode.right!=null) next.add(treeNode.right);
            }
            current=next;
        }
        int res[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }


}
