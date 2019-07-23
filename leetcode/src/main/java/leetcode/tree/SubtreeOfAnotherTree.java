package leetcode.tree;

import java.util.Stack;

public class SubtreeOfAnotherTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {

        String s1 = preOrder(s);
        String s2 = preOrder(t);

        return  s1.contains(s2);

    }

    String preOrder(TreeNode root){
        String res = "";
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        if(!stack.isEmpty()){

            TreeNode node = stack.pop();
            if(node != null) {
                res = res + node.val;
                stack.add(node.right);
                stack.add(node.left);

            }else {
                res +="null";
            }
        }

        return  res;

    }

    String preOrder2(TreeNode root){
        String res = "";
        res =res+1;

        return  res;

    }

    public static void main(String[] args) {


        TreeNode root= new TreeNode(3);
        TreeNode root1= new TreeNode(4);
        TreeNode root2= new TreeNode(5);
        root.left=root1;
        root.right=root2;


        System.out.println( new SubtreeOfAnotherTree().preOrder(root));
    }
}
