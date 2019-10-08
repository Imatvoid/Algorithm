`Merge k Sorted Lists`

<https://leetcode.com/problems/merge-k-sorted-lists/>

`23. 合并K个排序链表`

<https://leetcode-cn.com/problems/merge-k-sorted-lists/>

## 描述

合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:
````
输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
````

## 思路

使用优先级队列对所有节点排序.

```java
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

        for (ListNode listNode : lists) {
            if (listNode != null)
                queue.offer(listNode);
        }

        while (!queue.isEmpty()) {
            head.next = queue.poll();
            head = head.next;

            if (head.next != null)
                queue.offer(head.next);
        }
        return dummy.next;
    }
```
