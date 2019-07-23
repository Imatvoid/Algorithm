package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();

        List<Node> pl = new ArrayList<Node>();
        pl.add(node);

        while (pl.size() > 0) {

            List<Node> pt = new ArrayList<Node>();
            for (Node n : pl) {
                if (!map.containsKey(n)) {
                    Node temp = new Node();
                    temp.val = n.val;
                    List<Node> nei = new ArrayList<Node>();
                    nei.addAll(n.neighbors);
                    temp.neighbors = nei;
                    map.put(n, temp);

                    for (Node n1 : n.neighbors) {
                        pt.add(n1);
                    }
                }
            }
            pl.clear();
            pl.addAll(pt);
        }
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            List<Node> temp = new ArrayList<Node>();
            for (Node n1 : entry.getValue().neighbors) {
                temp.add(map.get(n1));
            }
            entry.getValue().neighbors = temp;
        }

        return map.get(node);

    }

    public static void main(String[] args) {

        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);

        List<Node> l1 = new ArrayList<Node>();
        l1.add(node2);
        l1.add(node4);
        node1.neighbors = l1;

        List<Node> l2 = new ArrayList<Node>();
        l2.add(node1);
        l2.add(node3);
        node2.neighbors = l2;


        List<Node> l3 = new ArrayList<Node>();
        l3.add(node2);
        l3.add(node4);
        node3.neighbors = l3;

        List<Node> l4 = new ArrayList<Node>();
        l4.add(node1);
        l4.add(node3);
        node4.neighbors = l4;


        new CloneGraph().cloneGraph(node1);

    }


}
