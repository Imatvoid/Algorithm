import leetcode.linkedlist.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Prac {


    public static void main(String[] args) throws InterruptedException {


    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode p = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return head;
    }


}
