package leetcode.tree;

public class BalancedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean res = true;
    public boolean isBalanced(TreeNode root) {

        countDepth(root);
        return res;


    }
    int countDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = countDepth(root.left);
            int right = countDepth(root.right);
            if(left-right>1 || right -left>1){
                res =false;
            }
            return 1 + Math.max(left, right);
        }

    }
}
