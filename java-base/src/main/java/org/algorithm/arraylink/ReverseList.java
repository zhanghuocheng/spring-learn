package org.algorithm.arraylink;


import java.util.List;

public class ReverseList {
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

    private static ListNode tail = null;

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        findNextNode(head);
        return tail;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        ListNode listNode3 = reverseList(listNode);
        while (listNode3 != null) {
            System.out.println(listNode.val);
            listNode3 = listNode3.next;
        }
    }

    public static ListNode findNextNode(ListNode head) {
        if (head.next != null) {
            ListNode temp = findNextNode(head.next);
            temp.next = head;
            return head;
        } else {
            tail = head;
            return head;
        }
    }
}
