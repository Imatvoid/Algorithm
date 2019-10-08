`21. Merge Two Sorted Lists`

<https://leetcode.com/problems/merge-two-sorted-lists/>

`21. 合并两个有序链表`

<https://leetcode-cn.com/problems/merge-two-sorted-lists/>

## 描述
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：
````
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
````

## 思路
类似归并排序.


```java
/**
     * 类似归并排序 3 while
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode l = new ListNode(0);
        ListNode lr = l;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l.next = l1;
                l = l.next;
                l1 = l1.next;
            } else {
                l.next = l2;
                l = l.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            l.next = l1;
            l = l.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            l.next = l2;
            l = l.next;
            l2 = l2.next;

        }
        return lr.next;

    }
```