package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    /**
     * 二叉树层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // offer 更好，但在这里一样。容量无限
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 这里也算一个小点。
            int levelNum = queue.size();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode t = queue.poll();

                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
                temp.add(t.val);
            }
            res.add(temp);
        }

        return res;

    }
}


