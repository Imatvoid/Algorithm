package leetcode.linkedlist;

public class LinkedListCycleII {




    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean res = false;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                res = true;
                slow = head;
                break;
            }
        }
        if (res) {
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        } else {
            return null;
        }


    }
}
