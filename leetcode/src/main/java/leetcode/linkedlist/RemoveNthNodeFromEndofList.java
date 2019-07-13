package leetcode.linkedlist;

public class RemoveNthNodeFromEndofList {


    /**
     * 移除链表的倒数第K个节点
     * 双指针
     * 注意可能会移除头节点的情况
     * 注意空的判断
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        // consider remove the origin head
        ListNode p = new ListNode(-1);
        p.next = head;

        // early 和 last 之间相差n个距离,当early到达null,last到达倒数第n个节点
        // 1-2-3-4-5 n=2
        ListNode earlyStart = p;
        ListNode lastStart = p;

        ListNode pre = null;
        int k = 0;
        while (earlyStart != null) {
            earlyStart = earlyStart.next;
            k++;
            if (k > n) {
                pre = lastStart;
                lastStart = lastStart.next;
            }

        }
        // find
        pre.next = lastStart.next;
        return p.next;

    }
}
