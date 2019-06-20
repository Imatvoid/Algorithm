---
title: 147. Insertion Sort List(使用插入排序对链表进行排序)
date: 2019-05-20 21:22:06
tags:

- leetcode-medium
- leetcode-linkedlist
- leetcode-sort
categories:
- leetCode
---

## Desc

Sort a linked list using insertion sort.



![img](https://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif)
A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list

**Algorithm of Insertion Sort:**

1. Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
2. At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
3. It repeats until no input elements remain.


**Example 1:**

```
Input: 4->2->1->3
Output: 1->2->3->4
```

**Example 2:**

```
Input: -1->5->3->4->0
Output: -1->0->3->4->5
```

## 描述

使用插入排序对链表进行排序



## 思路

见插入排序

## 实现

```java
 public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tmp = head.next;
        ListNode pre = head;
        int index = 2;
        while (tmp != null) {

            int index2 = findIndex(head, tmp);
            // 1 3 2=tmp
            if (index2 < index) {
                pre.next = tmp.next;
                head = insertList(head, index2, tmp);
                tmp = pre.next;
            }
            // 1 2 3=tmp
            else {
                pre = tmp;
                tmp = tmp.next;
            }
            index++;

        }
        return  head;

    }

    int findIndex(ListNode head, ListNode listNode) {
        int index = 1;
        while (head.val < listNode.val ) {
            head = head.next;
            index++;
        }

        return index;

    }

    ListNode insertList(ListNode head, int index, ListNode insert) {
        if (index == 1) {
            insert.next = head;
            return insert;
        }
        ListNode tmp = head;
        index = index - 2;
        while (index > 0) {
            tmp = tmp.next;
            index--;
        }
        insert.next = tmp.next;
        tmp.next = insert;
        return head;

    }

```

