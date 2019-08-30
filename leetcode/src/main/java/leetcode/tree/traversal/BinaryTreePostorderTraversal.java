package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: yangxu
 * @Date: 2019/8/26 下午11:42
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {


        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            if (p != null) {
                result.addFirst(p.val);
                stack.push(p.left);
                stack.push(p.right);

            }
        }
        return result;


    }
}