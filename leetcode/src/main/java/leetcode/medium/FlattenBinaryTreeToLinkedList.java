package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Definition for a binary leetcode.tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    List<TreeNode> list = new ArrayList<TreeNode>();

    public void flatten(TreeNode root) {
        //addList(root);
        addListNoRecursion(root);

        if (list.size() == 0 || list.size() == 1) {
            return;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }


    }

    /**
     * 递归先序遍历
     *
     * @param node
     */
    void addList(TreeNode node) {
        if (node != null) {
            list.add(node);

            addList(node.left);
            addList(node.right);
        }
    }


    /**
     * 非递归先序遍历
     * @param node
     */
    void addListNoRecursion(TreeNode node){

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(node);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp !=null){
                list.add(temp);
                if(temp.right != null){
                    stack.add(temp.right);
                }

                if(temp.left != null){
                    stack.add(temp.left);
                }
            }
        }


    }

}
