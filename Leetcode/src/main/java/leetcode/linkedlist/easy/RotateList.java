package leetcode.linkedlist.easy;

import leetcode.linkedlist.ListNode;

/**
 * @Author: yangxu
 * @Date: 2019/8/19 下午11:39
 */
public class RotateList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    ListNode tail = null;

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = len(head);
        int ops = k % len;
        // 无需操作,比如[1,2] k=2
        if (ops == 0) return head;

        ListNode pre = new ListNode(-1);
        pre.next = head;

        // 起码俩元素
        // 1 2 3(pre) 4(p) 5
        ops = len - ops;
        ListNode p = head;
        while (ops > 0) {
            ops--;
            p = p.next;
            pre = pre.next;
        }
        // 1 2 3(pre) 4(p) 5(tail)
        pre.next = null;
        tail.next = head;

        return p;

    }

    public int len(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            //拿到最后一个节点.
            tail = head;
            head = head.next;
        }
        return len;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        new RotateList().rotateRight(l1, 2);
    }
}
