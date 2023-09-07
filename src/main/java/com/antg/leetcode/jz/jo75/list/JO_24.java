package com.antg.leetcode.jz.jo75.list;
/**
* @author:Antg
* @create: 2023/9/7
* @Description:
 * 剑指 Offer 24. 反转链表
 * https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_24 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        reverseList(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        // 先逆序转换成一个数组,然后在给现在的链表重新赋值
        int[] arr = reversePrint(head);
        ListNode tmp = head;
        for (int ele : arr) {
            tmp.val=ele;
            tmp=tmp.next;
        }
        return head;
    }
    public static int[] reversePrint(ListNode head) {
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


        return res;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
