package com.antg.leetcode.jz.jo75.double_pointer;

import java.util.HashSet;
import java.util.Set;

public class JO_52 {
    public static void main(String[] args) {

    }
    /**
    * @author:Antg
    * @create: 2023/9/8
    * @Description:
     * 暴力破解
    */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a =headA;
        while (a!=null){
            ListNode b = headB;
            while (b!=null){
                if(a==b){
                    return a;
                }
                b=b.next;
            }
            a=a.next;
        }
        return null;
    }

    /**
    * @author:Antg
    * @create: 2023/9/8
    * @Description: 哈希集合法
    */

    ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode a = headA;
        ListNode b = headB;
        while (a!=null){
            set.add(a);
            a=a.next;
        }
        while (b!=null){
            if(set.contains(b)){
                return b;
            }
            b=b.next;
        }
        return null;
    }

    /**
    * @author:Antg
    * @create: 2023/9/8
    * @Description: 双指针
    */

    ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }

        ListNode a=headA,b=headB;
        while (a!=b){
            a=a==null?headB:a.next;
            b=b==null?headA:b.next;
        }
        return a;
    }

    /**
    * @author:Antg
    * @create: 2023/9/8
    * @Description: 长度对其法
    */

    ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        int al=0,bl=0;
        ListNode a=headA,b=headB;
        while (a!=null){
            al++;
            a=a.next;
        }
        while (b!=null){
            bl++;
            b=b.next;
        }

        while (al>bl){
            headA=headA.next;
            al--;
        }

        while (bl>al){
            headB=headB.next;
            bl--;
        }
        while (headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;


    }

}
