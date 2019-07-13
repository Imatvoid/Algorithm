package leetcode.linkedlist;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MergekSortedLists {


    public ListNode mergeKLists2(ListNode[] lists) {

        Map<Integer,Integer> map =new TreeMap<Integer, Integer>();
        for(ListNode node :lists){
            while (node !=null){
                map.put(node.val,map.getOrDefault(node.val,0)+1);
            }
        }

        ListNode node  =new ListNode(-1);
        ListNode head = node ;

        for(Map.Entry<Integer,Integer>  entry: map.entrySet()){
            int count = entry.getValue();
            while (count-->0){
                ListNode p  =new ListNode(entry.getKey());
                node.next=p;
                node=p;
            }
        }
        return  head.next;



    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
