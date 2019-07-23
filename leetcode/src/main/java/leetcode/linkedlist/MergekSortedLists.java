package leetcode.linkedlist;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MergeKSortedLists {


    public ListNode mergeKLists2(ListNode[] lists) {

        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (ListNode node : lists) {
            while (node != null) {
                map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            }
        }

        ListNode node = new ListNode(-1);
        ListNode head = node;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            while (count-- > 0) {
                ListNode p = new ListNode(entry.getKey());
                node.next = p;
                node = p;
            }
        }
        return head.next;


    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        for (ListNode node : lists) {
            if (node != null)
                queue.offer(node);
        }

        while (!queue.isEmpty()) {
            head.next = queue.poll();
            head = head.next;

            if (head.next != null)
                queue.offer(head.next);
        }
        return dummy.next;
    }
}
