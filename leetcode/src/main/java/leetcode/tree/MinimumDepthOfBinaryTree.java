package leetcode.tree;

public class MinimumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    class Solution {
        public int minDepth(TreeNode root) {
            if(root == null){
                return 0;
            }else{
                int left = minDepth(root.left);
                int right = minDepth(root.right);
                if(left==0) return right+1;
                if(right==0) return left+1;
                return 1+Math.min(left,right);
            }

        }
    }
}
