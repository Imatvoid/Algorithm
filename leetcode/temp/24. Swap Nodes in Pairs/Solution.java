/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
   public ListNode swapPairs(ListNode head) {

        ListNode tempNode = head;

        int length =1;
        ListNode foreNode = new ListNode(-1);
        foreNode.next = head;


        while (tempNode!=null){

            ListNode p = tempNode.next;

            if(length%2==0){
                if(length ==2){
                    head = tempNode;
                }
                foreNode.next.next=tempNode.next;
                tempNode.next =foreNode.next;
               foreNode.next = tempNode;
                foreNode = tempNode.next;
              
            }
            tempNode=p;
            length++;


        }

        return  head;



    }
}