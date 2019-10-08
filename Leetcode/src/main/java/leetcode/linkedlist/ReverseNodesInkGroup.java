package leetcode.linkedlist;

public class ReverseNodesInkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        // 至少有两个节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode t = head;
        ListNode pre = dummy;
        int i = 1;

        while (t != null) {
            if (i % k == 0) {
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
