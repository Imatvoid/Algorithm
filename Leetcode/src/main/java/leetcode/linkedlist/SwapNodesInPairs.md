`24. Swap Nodes in Pairs`

<https://leetcode.com/problems/swap-nodes-in-pairs/>

`24. 两两交换链表中的节点`

<https://leetcode-cn.com/problems/swap-nodes-in-pairs/>

### 描述
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.



### 思路

先提取一个公共方法,可以反转链表，返回头尾节点。

建立一个dummy节点，dummy.next=head。 方便反转头节点。

剩下的都是正常操作了，这个可以拓展到K。 把  `i % 2 ==0` 变成 `i % k== 0`即可


```java
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
```