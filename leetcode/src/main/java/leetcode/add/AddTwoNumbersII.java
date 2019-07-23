package leetcode.add;

import java.util.Stack;

public class AddTwoNumbersII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

      return null;
    }
    /**
     * 栈
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 =new Stack<ListNode>();
        Stack<ListNode> s2 =new Stack<ListNode>();
        while (l1!=null){
            s1.push(l1);
            l1=l1.next;
        }
        while (l2!=null){
            s2.push(l2);
            l2=l2.next;
        }

        int over = 0;
        ListNode temp =null;


        while (!s1.isEmpty() || !s2.isEmpty()){
            ListNode a = s1.isEmpty()?new ListNode(0):s1.pop();
            ListNode b = s2.isEmpty()?new ListNode(0):s2.pop();
            int sum = (a.val+b.val+over)%10;
            over = (a.val+b.val+over)/10;

            ListNode temp2 =  new ListNode(sum);
            temp2.next = temp;
            temp= temp2;


        }

        if(over == 1){
            ListNode temp2 =  new ListNode(1);
            temp2.next = temp;
            temp= temp2;
        }

        return temp;
    }

}
