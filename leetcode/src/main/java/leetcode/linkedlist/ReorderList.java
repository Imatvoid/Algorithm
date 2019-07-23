package leetcode.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import static leetcode.linkedlist.LinkedListUtils.reverse;

public class ReorderList {


    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 1-2-3(slow)-4-null(fast)
        // 1-2(slow)-3(fast)
        // 1-2(slow)-null(fast)
        ListNode n2 = slow.next;
        n2 = reverse(n2);
        // 这一步切分成两条链表
        slow.next=null;
        combine(head,n2);

    }

    public void combine(ListNode head,ListNode tail) {
        if(tail==null) return;

        ListNode pre = new ListNode(-1);
        while (head!=null&&tail!=null){
            pre.next=head;
            head=head.next;
            pre.next.next=tail;
            tail=tail.next;

            pre=pre.next.next;


        }
        pre.next = head;


    }




    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            new ReorderList().reorderList(head);
            String out = listNodeToString(head);

            System.out.print(out);
        }
    }

}
