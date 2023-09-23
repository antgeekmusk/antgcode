package com.antg.leetcode.jz.jo75.search_backtrack;

import com.beust.ah.A;

import java.util.ArrayList;
import java.util.List;

/**
* @author:Antg
* @create: 2023/9/23
* @Description:
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/?envType=study-plan-v2&envId=coding-interviews
 * LCR 151. 彩灯装饰记录 III
*/
public class JO_151 {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        List<List<Integer>> res =new ArrayList<>();
        if(root==null) return res;
        List<TreeNode> cur = new ArrayList<>();
        boolean flag=true; // true 正序,false 反序
        cur.add(root);
        while (!cur.isEmpty()){
            List<TreeNode> next = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < cur.size(); i++) {
                if(flag){
                   tmp.add(cur.get(i).val);
                }else{
                    tmp.add(cur.get(cur.size()-i-1).val);
                }
                if(cur.get(i).left!=null) next.add(cur.get(i).left);
                if(cur.get(i).right!=null) next.add(cur.get(i).right);
            }
            //取反
            flag=!flag;
            cur=next;
            res.add(tmp);
        }
        return res;

    }
}
