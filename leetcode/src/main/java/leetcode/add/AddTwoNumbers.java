package leetcode.add;

public class AddTwoNumbers {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode(-1);
        ListNode res = temp;


        int over = 0;
        while (l1!=null || l2!=null){
            ListNode a = l1==null? new ListNode(0) :l1;
            //这里可能需要特殊处理下
            l1 = l1==null?null:l1.next;

            ListNode b = l2==null? new ListNode(0) :l2;
            l2 = l2==null?null:l2.next;
            int sum = (a.val +b.val+over)%10;
            over = (a.val +b.val+over)/10;
            temp.next = new ListNode(sum);
            temp =temp.next;

        }
        if(over == 1){
            temp.next =new ListNode(1);
        }
        return  res.next;

    }
}
