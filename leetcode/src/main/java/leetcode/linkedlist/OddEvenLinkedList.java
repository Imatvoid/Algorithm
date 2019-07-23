package leetcode.linkedlist;



public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if(head ==null | head.next ==null){
            return  head;
        }

        ListNode odd  = head;
        ListNode even = head.next;
        // 这里要提前保存下
        ListNode evenHead = even;
        while (even !=null && even.next!=null){
            odd = odd.next = even.next;
            even = even.next = odd.next;
        }

        odd.next = evenHead;

        return  head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode head =l1;
        for(int i=2;i<=5;i++){
            head.next = new ListNode(i);
            head=head.next;
        }
        new OddEvenLinkedList().oddEvenList(l1);

    }
}
