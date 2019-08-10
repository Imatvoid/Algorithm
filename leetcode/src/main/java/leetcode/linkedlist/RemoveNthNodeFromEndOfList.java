package leetcode.linkedlist;

public class RemoveNthNodeFromEndOfList {


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
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode preOrigin = pre;

        ListNode fir = head;
        ListNode sec = head;

        while (n--> 0) {
            sec = sec.next;
        }
        while (sec!=null){
            sec=sec.next;
            pre=fir;
            fir=fir.next;

        }
        pre.next=pre.next.next;
        return preOrigin.next;
    }
}
