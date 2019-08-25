`147. Insertion Sort List`

<https://leetcode.com/problems/insertion-sort-list/>

`147. 对链表进行插入排序`

<https://leetcode-cn.com/problems/insertion-sort-list/>
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

        ListNode Dummy = new ListNode(-1);//这里只是起一个新节点,不与head关联.

        ListNode cur = head;
        while (cur !=null){
            ListNode pre = Dummy;
            ListNode next = cur.next;
            while (pre.next !=null && pre.next.val < cur.val){
                pre =pre.next;
            }
            cur.next = pre.next;
            pre.next=cur;

            cur =next;
        }
        return  Dummy.next;
    }
```

