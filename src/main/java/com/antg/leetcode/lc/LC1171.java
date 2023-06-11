package com.antg.leetcode.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 从链表中删去总和值为零的连续节点
 * </p>
 *
 * @author Antg
 * @since 2023/6/11 17:30
 **/
public class LC1171 {
    public static void main(String[] args) {
        ListNode e = new ListNode(1);
        ListNode d = new ListNode(3, e);
        ListNode c = new ListNode(-3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        ListNode res = removeZeroSumSublists(a);
        System.out.println(res.val);


    }

    /**
     * @author Antg
     * @description 使用map+前缀和
     * @time 2023/6/11 21:53
     **/
    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int prefix = 0;
        for (ListNode node = tmp; node != null; node = node.next) {
            prefix += node.val;
            map.put(prefix, node);
        }
        prefix = 0;
        for (ListNode node = tmp; node != null; node = node.next) {
            prefix += node.val;
            node.next = map.get(prefix).next;
        }
        return tmp.next;
    }

    /**
     * @author Antg
     * @description 回溯
     * @time 2023/6/11 21:54
     **/
    public static ListNode removeZeroSumSublists2(ListNode head) {
        if (head == null) return null;
        int sum = 0;
        for (ListNode node = head; node != null; node = node.next) {
            sum += node.val;
            if (sum == 0) return removeZeroSumSublists2(node.next);
        }
        head.next = removeZeroSumSublists2(head.next);
        return head;
    }


    //    Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
