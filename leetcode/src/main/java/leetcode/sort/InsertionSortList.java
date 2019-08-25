package leetcode.sort;

import leetcode.linkedlist.ListNode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode Dummy = new ListNode(-1);//这里只是起一个新节点,不与head关联.

        ListNode cur = head;
        while (cur !=null){
            ListNode pre = Dummy;
            ListNode next = cur.next;
            while (pre.next !=null && pre.next.val < cur.val){
                pre =pre.next;
            }
            cur.next = pre.next;
            pre.next=cur;

            cur =next;
        }
        return  Dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l4.next=l1;
        l1.next=l3;
        l3.next=l2;
        new InsertionSortList().insertionSortList(l4);

    }

    int findIndex(ListNode head, ListNode listNode) {
        int index = 1;
        while (head.val < listNode.val ) {
            head = head.next;
            index++;
        }

        return index;

    }

    ListNode insertList(ListNode head, int index, ListNode insert) {
        if (index == 1) {
            insert.next = head;
            return insert;
        }
        ListNode tmp = head;
        index = index - 2;
        while (index > 0) {
            tmp = tmp.next;
            index--;
        }
        insert.next = tmp.next;
        tmp.next = insert;
        return head;

    }

}
