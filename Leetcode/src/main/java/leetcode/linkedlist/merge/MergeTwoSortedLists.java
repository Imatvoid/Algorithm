package leetcode.linkedlist.merge;

import leetcode.linkedlist.ListNode;

/**
 * @Author: yangxu
 * @Date: 2019/8/23 上午8:31
 */
public class MergeTwoSortedLists {
    /**
     * 类似归并排序 3 while
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode l = new ListNode(0);
        ListNode lr = l;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l.next = l1;
                l = l.next;
                l1 = l1.next;
            } else {
                l.next = l2;
                l = l.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            l.next = l1;
            l = l.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            l.next = l2;
            l = l.next;
            l2 = l2.next;

        }
        return lr.next;

    }
}
