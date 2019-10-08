package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {

        Node temp = head;

        Map<Node, Node> map = new HashMap<Node, Node>();

        while (temp != null) {
            map.put(temp, new Node(temp.val, null, null));
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);


    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
