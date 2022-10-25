package org.algorithm;

import org.algorithm.base.ListNode;


public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(21);ListNode listNode1=new ListNode(22);
        listNode.next=listNode1;
        addTwoNumbers(listNode,null);
        System.out.println(listNode.val);
    }

    public static ListNode  addTwoNumbers(ListNode listNode ,ListNode listNode1){
       ListNode temp= listNode;
       temp.val=1000;
       return temp;
    }
}

