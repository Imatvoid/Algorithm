package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val + ",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    sb.append("nil" + ",");
                }
            }

        }
        return sb.substring(0, sb.length() - 1);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] tree = data.split(",");
        int i = 1;
        TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (i < tree.length) {
            TreeNode node = queue.poll();

            if (!"nil".equals(tree[i])) {
                node.left = new TreeNode(Integer.parseInt(tree[i]));
                queue.offer(node.left);
            }

            if (!"nil".equals(tree[i + 1])) {
                node.right = new TreeNode(Integer.parseInt(tree[i+1]));
                queue.offer(node.right);
            }

            i += 2;

        }
        return root;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.right =  new TreeNode(2);
        new SerializeAndDeserializeBinaryTree().serialize(root);
    }
}
