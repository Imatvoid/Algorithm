package leetcode.linkedlist;

public class ReverseNodesInkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode res1 = null;
        boolean b = true;

        ListNode res2 = head;

        int i = 1;
        ListNode pre = new ListNode(-1);
        pre.next=head;
        while (head != null) {
            head = head.next;
            i++;
            if (i == k && head != null) {
                ListNode t = head.next;
                ListNode tail = pre.next;

                head.next = null;
                if (b) {
                    res1 = reverse(pre.next);
                    b = false;
                } else {
                    pre.next = reverse(pre.next);
                }
                tail.next = t;
                pre = tail;
                head = t;
                i = 1;

            }
        }

        if (!b) {
            return res1;
        } else {
            return res2;
        }
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode t = head.next;
            head.next = pre;
            pre = head;
            head = t;
        }
        return pre;

    }

    public static void main(String[] args) {
        ListNode o1 = new ListNode(1);
        ListNode o2 = new ListNode(2);
        ListNode o3 = new ListNode(3);
        ListNode o4 = new ListNode(4);
        ListNode o5 = new ListNode(5);
        o1.next =o2;
        o2.next =o3;
        o3.next =o4;
        o4.next =o5;
        new ReverseNodesInkGroup().reverseKGroup(o1,2);
    }

}
