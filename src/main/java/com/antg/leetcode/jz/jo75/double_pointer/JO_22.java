package com.antg.leetcode.jz.jo75.double_pointer;
/**
* @author:Antg
* @create: 2023/9/7
* @Description:
 * 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_22 {
    public static void main(String[] args) {

    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 求出链表的长度
        int cnt=0;
        ListNode tmp =head;
        while (tmp!=null){
            cnt++;
            tmp=tmp.next;
        }
        while (cnt-k>0){
            head=head.next;
            cnt--;
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
