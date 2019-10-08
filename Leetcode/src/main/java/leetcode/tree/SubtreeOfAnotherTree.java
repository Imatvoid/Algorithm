package leetcode.tree;

import java.util.LinkedList;
import java.util.Stack;

public class SubtreeOfAnotherTree {


    public boolean isSubtree(TreeNode s, TreeNode t) {

        String s1 = preOrder(s);
       // System.out.println(s1);
        String s2 = preOrder(t);
       // System.out.println(s2);
        return s1.contains(s2);

    }

    String preOrder(TreeNode root) {
        String res = "";
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                res = res +"," +node.val;
                stack.push(node.right);
                stack.push(node.left);

            } else {
                res += ",null";
            }
        }

        return res;

    }


    public static void main(String[] args) {

//        LinkedList<Integer> linkedList = new LinkedList<Integer>();
//        linkedList.push(1);
//        linkedList.push(null);
//        linkedList.push(null);
//        linkedList.push(null);
//        System.out.println(linkedList.size());
//        System.out.println(linkedList.pop());
//        System.out.println(linkedList.pop());
//        System.out.println(linkedList.pop());
//        System.out.println(linkedList.pop());
//        System.out.println(linkedList.pop());


        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(5);
        root.left = root1;
        root.right = root2;


        System.out.println(new SubtreeOfAnotherTree().preOrder(root));
    }
}
