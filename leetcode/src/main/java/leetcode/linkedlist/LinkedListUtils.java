package leetcode.linkedlist;

public class LinkedListUtils {

    public static int len(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static ListNode findK(ListNode head, int k) {
        // 我已经在head了
        k--;

        while (k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre =null;
        while (head!=null){

            ListNode next = head.next;

            head.next=pre;
            pre = head;

            head = next;
        }

        return pre;

    }



}
