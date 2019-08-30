package leetcode.tree.traversal.notverymeaningful;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        boolean flag = false;
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.pollLast();
                if (node != null) {
                    if (flag) {
                        list.addFirst(node.val);
                    } else {
                        list.add(node.val);
                    }
                    queue.addFirst(node.left);
                    queue.addFirst(node.right);
                }
            }
            if(list.size()>0) {
                res.add(list);
            }
            flag = !flag;
        }
        return res;

    }
}
