package com.antg.leetcode.jz.jo75.double_pointer;
/**
* @author:Antg
* @create: 2023/9/7
* @Description:
 * 剑指 Offer 18. 删除链表的节点
 * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_18 {
    public static void main(String[] args) {

    }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode cursor = head.next;
        ListNode before = head;
        if(head.val==val) return head.next;
        while (cursor!=null){
            if(cursor.val==val){
                before.next=cursor.next;
            }
            before=cursor;
            cursor=cursor.next;
        }
        return head;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
