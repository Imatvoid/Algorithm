## 19. Remove Nth Node From End of List
> 当我们用一个指针遍历链表不能解决问题的时候，可以尝试用两个指针来遍历链表。可以让其中一个指针遍历的速度快一些（比如一次在链表上走两步），或者让它先在链表上走若干步。

## Desc

Given a linked list, remove the *n*-th node from the end of list and return its head.

**Example:**

```
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```

**Note:**

Given *n* will always be valid.

**Follow up:**

Could you do this in one pass?



## 描述

只遍历一次,移除链表倒数第k个节点

#### Tips

- 注意会移除头节点情况
- 注意从1开始数，这不是数组
- 思维不要固化



## 思路

快慢指针

early 和 last 之间相差n个距离,当early到达null,last到达倒数第n个节点

比如 1-2-3-4-5 n=2

early先到节点3,然后last出发,最后early到达null,last到达倒数第2个节点

```java
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
        // 可能会移除头节点
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
```



