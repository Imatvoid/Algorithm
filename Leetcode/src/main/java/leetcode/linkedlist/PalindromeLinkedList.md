234. Palindrome Linked List(回文链表判断)

<https://leetcode.com/problems/palindrome-linked-list/>

234. 回文链表

<https://leetcode-cn.com/problems/palindrome-linked-list/>

## Desc

Given a singly linked list, determine if it is a palindrome.

**Example 1:**

```
Input: 1->2
Output: false
```

**Example 2:**

```
Input: 1->2->2->1
Output: true
```

**Follow up:**
Could you do it in O(n) time and O(1) space?


## 思路


判断回文链表 O(n) O(1)


快慢指针找中间节点 

1 2 3  slow—>2 

反转后:   

  1 2 null
  3 2 null
  注意1依然指向2(便于最后恢复),没有做切断,但2已经指向null

1 2 3 4  slow->3  

反转后:

  1 2 null
  4 3 null
  注意2依然指向3(便于最后恢复),没有做切断),但3已经指向null
```java
 /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        // 通常需要考虑的因素是0和1的情况
        if(head == null || head.next == null){
            return  true;
        }
        ListNode fast = head;
        ListNode slow = head;

        // 寻找中间节点
        // 1-2 slow=2 fast=null
        // 1-2-3 slow=2 fast=3
        // 1-2-3-4 slow=3 fast=null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        // 倒转中间后边的链表 但是没有切断前面的指向
        slow = reverseLinkedList(slow);
        // 最后要恢复
        ListNode save = slow;

        fast = head;
        boolean res = true;

        while (slow != null) {
            if (slow.val != fast.val) {
                res = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        reverseLinkedList(save);
        return res;


    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
```