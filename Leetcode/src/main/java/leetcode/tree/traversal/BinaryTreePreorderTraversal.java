package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {


    /**
     * 先序列遍历非递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> resList = new LinkedList<Integer>();
        LinkedList<TreeNode> stack =new LinkedList<TreeNode>();

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                resList.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return  resList;
    }
}
