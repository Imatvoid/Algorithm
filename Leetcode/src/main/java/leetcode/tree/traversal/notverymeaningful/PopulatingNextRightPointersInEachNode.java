package leetcode.tree.traversal.notverymeaningful;

import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.push(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.get(i).next = queue.get(i + 1);
            }

            while (size-- > 0) {
                Node node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }


        }
        return root;
    }

    public static void main(String[] args) {
        Node left = new Node(2, null, null, null);
        Node right = new Node(3, null, null, null);
        Node root = new Node(1, left, right, null);
        new PopulatingNextRightPointersInEachNode().connect(root);
    }
}
