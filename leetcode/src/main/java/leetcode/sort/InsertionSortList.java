package leetcode.sort;

import leetcode.linkedlist.ListNode;

public class InsertionSortList {

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

    void insetSort(int [] arr,int start, int end){

        for (int i = start+1; i <= end ; i++) {
            int tmp = arr[i];
            int j =i-1;
            while (j>= 0 && arr[j]>tmp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=tmp;

        }

    }

}
