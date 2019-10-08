package leetcode.add;

public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        int over = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            l1 = l1 == null ? null : l1.next;
            int n2 = l2 != null ? l2.val : 0;
            l2 = l2 == null ? null : l2.next;

            int bit = (n1 + n2 + over) % 10;
            over = (n1 + n2 + over) / 10;
            temp.next = new ListNode(bit);
            temp = temp.next;

        }
        if (over > 0) {
            temp.next = new ListNode(1);
        }

        return res.next;

    }

    public static void main(String[] args) {

    }
}
