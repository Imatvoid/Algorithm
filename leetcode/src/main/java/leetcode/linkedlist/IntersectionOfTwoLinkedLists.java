package leetcode.linkedlist;



public class IntersectionOfTwoLinkedLists {




    /**
     * 通用做法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null|| headB==null){
            return  null;
        }

        int len1 = getLen(headA);
        int len2 = getLen(headB);

        ListNode start1 = headA;
        ListNode start2 = headB;
        if(len1>len2){
            int c =len1-len2;
            while (c>0) {
                start1=start1.next;
                c--;

            }
        }
        if(len2>len1){
            int c =len2-len1;
            while (c>0) {
                start2=start2.next;
                c--;

            }
        }
        while (start1!=null && start2!=null&&start1!=start2){
            start1 =start1.next;
            start2 =start2.next;

        }

        return  start1==null?null:start1;



    }
    public int getLen(ListNode node){
        int res = 0;
        while (node!=null){
            res++;
            node=node.next;
        }
        return res;
    }

    /**
     * 一种异常巧妙的做法。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeBest(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        // 如果没有交点,会一起等于null跳出来
        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        return a;
    }
}
