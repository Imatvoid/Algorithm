> 当我们用一个指针遍历链表不能解决问题的时候，可以尝试用两个指针来遍历链表。可以让其中一个指针遍历的速度快一些（比如一次在链表上走两步），或者让它先在链表上走若干步。

237. Delete Node in a Linked List

<https://leetcode.com/problems/remove-nth-node-from-end-of-list/>

9. 删除链表的倒数第N个节点

<https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/>
## 描述

给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：
```
给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
```
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？


## 思路

一前一后两个节点, 相距离n, 当后面的节点到null,前面的节点到倒数第n个节点.

```java
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
```