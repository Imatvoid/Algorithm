/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

            if (head == null) {
                return head;
            }
            ListNode headt = head;
            int length = 0;
            while (headt != null) {
                length++;
                headt = headt.next;
            }
        
           
            n = length - n + 1;
            if(n==1){
                head=head.next;
                return head;
            }
           
            headt = head;
            int start = 1;
            while (start < n - 1) {
                start++;
                headt = headt.next;
            }
           
            headt.next = headt.next.next;
            
            return head;


        }
}