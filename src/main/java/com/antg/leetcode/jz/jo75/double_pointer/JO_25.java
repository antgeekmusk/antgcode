package com.antg.leetcode.jz.jo75.double_pointer;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author:Antg
* @create: 2023/9/8
* @Description:
 * 剑指 Offer 25. 合并两个排序的链表
 * https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_25 {
    public static void main(String[] args) {
//        int[] arr = {1,2,4,1,3,4};
//        // 冒泡排序
//        for (int i = 0; i < arr.length-1; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                int tmp=arr[i];
//                if(tmp>arr[j]){
//                    arr[i]=arr[j];
//                    arr[j]=tmp;
//                }
//            }
//        }
//        Arrays.stream(arr).forEach(System.out::println);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next=node2;
        node2.next=node3;

        ListNode node0 = new ListNode(5);
//        ListNode node4 = new ListNode(2);
//        ListNode node5 = new ListNode(3);
//        node0.next=node4;
//        node4.next=node5;

        mergeTwoLists2(node0,node1);



    }
    /**
    * @author:Antg
    * @create: 2023/9/8
    * @Description:
     * 思路 :
     * 1->2->4, 1->3->4
     * 1.先将所有的数据存储到一个list中 nodeList [1,2,4,1,3,4]
     * 2.根据这个数组进行链表重排
     * 3.返回最终结果
     *
     *
    */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1== null && l2==null) return null;
        List<ListNode> nodeList = new ArrayList<>();
        while (l1!=null){
            nodeList.add(l1);
            l1=l1.next;
        }
        while (l2!=null){
            nodeList.add(l2);
            l2=l2.next;
        }
        for (int i = 0; i < nodeList.size()-1; i++) {
            for (int j = i+1; j < nodeList.size(); j++) {
                ListNode tmp = nodeList.get(i);
                if(tmp.val>nodeList.get(j).val){
                    nodeList.set(i,nodeList.get(j));
                    nodeList.set(j,tmp);
                }
            }
        }
        for (int i = 0; i < nodeList.size()-1; i++) {
            nodeList.get(i).next=nodeList.get(i+1);
        }
        nodeList.get(nodeList.size()-1).next=null;

        return nodeList.get(0);
    }
    /**
    * @author:Antg
    * @create: 2023/9/8
    * @Description:
     * 滑动窗口 : 按照其中某一条链 l1 的两个节点进行滑动, node1 和 node2 [min,max]
     * 然后扫描另外一条链 l2, if l2.node>=min && l2.node<=max 接着判断下一个节点
    */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode base=null;
        ListNode scan=null;
        boolean flag=true;
        if(l1.val<=l2.val){
            base=l1;
            scan=l2;
        }else{
            base=l2;
            scan=l1;
            flag=false;
        }

        if(base.next==null){
            base.next=scan;
            return base;
        }

        while (base.next!=null){
            ListNode start=scan;
            ListNode end=null;
            while(scan!=null && scan.val>=base.val && scan.val<=base.next.val ){
                end=scan;
                scan=scan.next;
            }
            if(end!=null){
                ListNode tmp = base.next;
                base.next=start;
                end.next=tmp;
            }

            base=base.next;

            if(scan==null){
                break;
            }

            if(base.next==null && scan!=null){
                base.next=scan;
                break;
            }
        }
        return flag? l1 :l2;

    }

    /**
    * @author:Antg
    * @create: 2023/9/8
    * @Description: 递归
    */
    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }else if(l1.val<l2.val){
            l1.next=mergeTwoLists3(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists3(l1,l2.next);
            return l2;
        }

    }

    /**
    * @author:Antg
    * @create: 2023/9/8
    * @Description: 迭代
    */

    public static ListNode mergeTwoLists4(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode prehead=new ListNode(-1);
        ListNode pre=prehead;
        while (l1!=null && l2 !=null){
            if(l1.val<=l2.val){
                pre.next=l1;
                l1=l1.next;
            }else{
                pre.next=l2;
                l2=l2.next;
            }
            pre=pre.next;
        }
        pre.next= l1==null?l2:l1;

        return prehead.next;





        return null;
    }



    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
