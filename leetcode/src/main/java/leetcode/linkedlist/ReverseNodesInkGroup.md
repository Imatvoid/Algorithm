`25. Reverse Nodes in k-Group`

<https://leetcode.com/problems/reverse-nodes-in-k-group/>

`25. K 个一组翻转链表`

<https://leetcode-cn.com/problems/reverse-nodes-in-k-group/>

## 思路

给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

示例 :
```
给定这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5
```
说明 :

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

## 思路

主要用到反转链表,重新链接等操作

```java
 public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode res1 = null;
        boolean b = true;

        ListNode res2 = head;

        int i = 1;
        ListNode pre = new ListNode(-1);
        pre.next=head;
        while (head != null) {
            head = head.next;
            i++;
            if (i == k && head != null) {
                ListNode t = head.next;
                ListNode tail = pre.next;

                head.next = null;
                if (b) {
                    res1 = reverse(pre.next);
                    b = false;
                    tail.next = t;
                    pre = tail;
                    head = t;
                    i = 1;
                } else {
                    pre.next = reverse(pre.next);
                    tail.next = t;
                    pre = tail;
                    head = t;
                    i = 1;
                }

            }
        }

        if (!b) {
            return res1;
        } else {
            return res2;
        }
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode t = head.next;
            head.next = pre;
            pre = head;
            head = t;
        }
        return pre;

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
```