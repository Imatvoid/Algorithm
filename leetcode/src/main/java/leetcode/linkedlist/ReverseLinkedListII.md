# 92. Reverse Linked List II
+1

## Desc

Reverse a linked list from position *m* to *n*. Do it in one-pass.

**Note:** 1 ≤ *m* ≤ *n* ≤ length of list.

**Example:**

```
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
```

## 描述

反转链表第m-n个节点



## 思路

添加一个前置节点(反转1-2,len=5)

找到并保存第m+1个节点前面的节点,找到并保存第n+1个节点.

要反转的是m+1-n+1的节点.

然后再将反转的数组塞回去

```java
 public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode res = new ListNode(1);
        res.next = head;

        ListNode pre = findK(res, m);
        ListNode mNode = pre.next;

        ListNode nNode = findK(res, n+1);
        ListNode tail = nNode.next;
        // 切断
        nNode.next = null;

        // 塞回去
        pre.next = reverse(mNode);
        findK(pre.next,n-m+1).next=tail;

        return  res.next;


    }
    
    public static ListNode findK(ListNode head, int k) {
        // 我已经在head
        k--;
        while (k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre =null;
        while (head!=null){

            ListNode next = head.next;
            
            head.next=pre;
            pre = head;

            head = next;
        }

        return pre;

    }
```

