package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {



    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        inorderTraversal(res,root);

        return  res;
    }

    void inorderTraversal(List<Integer> res,TreeNode root){
        if(root == null){
            return;
        }
        inorderTraversal(res,root.left);
        res.add(Integer.valueOf(root.val));
        inorderTraversal(res,root.right);
    }




    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            // 一直走到最左端，直到left为null
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.poll();

            if (cur != null) {
                list.add(cur.val);
                stack.push(cur.right);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rr  = new TreeNode(2);
        rr.left = new TreeNode(3);
        root.right =rr;
        new BinaryTreeInorderTraversal().inorderTraversal(root);

    }
}
