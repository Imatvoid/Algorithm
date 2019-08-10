package leetcode.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static leetcode.linkedlist.LinkedListUtils.findK;
import static leetcode.linkedlist.LinkedListUtils.reverse;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode res = new ListNode(1);
        res.next = head;

        ListNode pre = findK(res, m);
        ListNode mNode = pre.next;

        ListNode nNode = findK(res, n+1);
        ListNode tail = nNode.next;
        nNode.next = null;

        pre.next = reverse(mNode);
        findK(pre.next,n-m+1).next=tail;

        return  res.next;

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
            line = in.readLine();
            int m = Integer.parseInt(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            ListNode ret = new ReverseLinkedListII().reverseBetween(head, m, n);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
