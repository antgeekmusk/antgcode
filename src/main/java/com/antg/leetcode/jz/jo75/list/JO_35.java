package com.antg.leetcode.jz.jo75.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author:Antg
* @create: 2023/9/7
* @Description:
 * 剑指 Offer 35. 复杂链表的复制
 * https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/?envType=study-plan-v2&envId=coding-interviews
*/
public class JO_35 {
    static Map<Node,Node> map = new HashMap<>();
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next=node2;
        node1.random=node3;
        node2.next=node3;
        node2.random=node2;
        node3.random=null;
        copyRandomList(node1);

    }

    public static Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node tmp = head;
        List<Node> list = new ArrayList();
        Map<Node,Integer> map = new HashMap();
        // 创建等量的孤立节点
        int index=0;
        while (tmp!=null){
            map.put(tmp,index);
            list.add(new Node(tmp.val));
            tmp=tmp.next;
            index++;
        }
        // 将链表链接起来
        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).next=list.get(i+1);
        }
        // 给random赋值
        map.forEach((node,i)->{
            if(node.random!=null){
                list.get(i).random=list.get(map.get(node.random));
            }else{
                list.get(i).random=null;
            }
        });
        return list.get(0);
    }

    // 递归写法
    public static Node copyRandomList2(Node head){
        if(head==null) return null;
        if(!map.containsKey(head)){
            Node node = new Node(head.val);
            map.put(head,node);
            node.next=copyRandomList2(head.next);
            node.random=copyRandomList2(head.random);
        }
        return map.get(head);
    }



    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
