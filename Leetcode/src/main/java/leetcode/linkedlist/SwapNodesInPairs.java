package leetcode.linkedlist;

/**
 * @Author: yangxu
 * @Date: 2019/8/28 下午9:59
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        // 至少有两个节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode t = head;
        ListNode pre = dummy;
        int i = 1;

        while (t != null) {
            if (i % 2 == 0) {
                ListNode next = t.next;
                t.next = null;
                ListNode[] res = reverse(pre.next);

                res[0].next = next;
                pre.next = res[1];
                pre = res[0];

                t = next;
                i++;

            } else {
                t = t.next;
                i++;
            }
        }


        return dummy.next;
    }

    ListNode[] reverse(ListNode head) {
        ListNode[] res = new ListNode[2];
        res[0] = head;
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        res[1]=pre;
        return res;

    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode no = new SwapNodesInPairs().swapPairs(l1);
        System.out.println();
    }
}
