package com.antg.leetcode.jz.jo75.list;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author:Antg
 * @create: 2023/9/7
 * @Description:
 *  剑指 Offer 06. 从尾到头打印链表
 *  https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/?envType=study-plan-v2&envId=coding-interviews
 */
public class JO_06 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        int[] res = reversePrint2(listNode);
        Arrays.stream(res).forEach(System.out::println);
    }

    // method 1 : use list cache data
    public static int[] reversePrint(ListNode head) {
        // 创建缓存list
        ArrayList<Integer> list = new ArrayList<>();

        while (head!=null){
            list.add(head.val);
            head=head.next;

        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(list.size()-i-1);
        }
        // 手动清理内存
        head=null;
        System.gc();

        return res;
    }

    // method 2 don't need new memory
    public static int[] reversePrint2(ListNode head) {
        // 先统计链表的长度
        int cnt=0;
        ListNode tmp = head;
        while (tmp!=null){
            cnt++;
            tmp=tmp.next;
        }
        // 创建数组开始反方向存储数据
        int res[] = new int[cnt];
        // 从新从开头遍历
        ListNode cur = head;
        for (int i = cnt-1; i >=0 ; i--) {
            res[i]=cur.val;
            cur = cur.next;
        }
        // 手动释放内存
        head=null;
        System.gc();

        return res;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
