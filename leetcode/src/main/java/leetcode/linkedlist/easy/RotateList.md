`61. Rotate List`

<https://leetcode.com/problems/rotate-list/>

`61. 旋转链表`

<https://leetcode-cn.com/problems/rotate-list/>

## 描述
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:
````
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
````
Example 2:
````
Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
````


## 思路

正常操作链表就行

`[1 2 3 4 5] k=2`

```java
 ListNode tail = null;

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = len(head);
        int ops = k % len;
        // 无需操作,比如[1,2] k=2
        if (ops == 0) return head;

        ListNode pre = new ListNode(-1);
        pre.next = head;

        // 起码俩元素
        // 1 2 3(pre) 4(p) 5
        ops = len - ops;
        ListNode p = head;
        while (ops > 0) {
            ops--;
            p = p.next;
            pre = pre.next;
        }
        // 1 2 3(pre) 4(p) 5(tail)
        pre.next = null;
        tail.next = head;

        return p;

    }

    public int len(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            //拿到最后一个节点.
            tail = head;
            head = head.next;
        }
        return len;

    }
```