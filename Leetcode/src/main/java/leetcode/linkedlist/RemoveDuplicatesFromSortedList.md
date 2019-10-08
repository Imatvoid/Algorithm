83. Remove Duplicates from Sorted List

<https://leetcode.com/problems/remove-duplicates-from-sorted-list/>

83. 删除排序链表中的重复元素

<https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/>


## 描述

给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:
```
输入: 1->1->2
输出: 1->2
```
示例 2:
```
输入: 1->1->2->3->3
输出: 1->2->3
```

## 思路

利用排序链表的特性.

```java
 public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode p = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return p;
    }
```

