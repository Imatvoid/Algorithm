package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 先序列遍历非递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<Integer>();
        Stack<TreeNode> stack =new Stack<TreeNode>();

        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                resList.add(node.val);
                stack.add(node.right);
                stack.add(node.left);
            }
        }
        return  resList;
    }
}
