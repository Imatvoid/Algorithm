package leetcode.tree.reverse;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {


    /**
     * 递归写法
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        TreeNode temp = left;
        root.left = right;
        root.right = temp;

        return root;
    }


    /**
     * 非递归写法
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue  = new LinkedList<TreeNode>();
        // offer 更好，但在这里一样。容量无限
        queue.add(root);
        while (!queue.isEmpty()){
            // 这里也算一个小点。
            int levelNum = queue.size();
            for(int i=0; i<levelNum; i++) {
                TreeNode node = queue.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

        }
        return root;
    }
}
