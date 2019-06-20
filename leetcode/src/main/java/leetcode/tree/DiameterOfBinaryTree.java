package leetcode.tree;

public class DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 二叉树最长的路径 两个递归  可优化
     * @param root
     * @return
     */
    public int diameterOfBinaryTreeNoBest(TreeNode root) {

        if(root==null){
            return 0;
        }
        int left =  getDepth(root.left);
        int right =  getDepth(root.right);

        return Math.max(Math.max(diameterOfBinaryTree(root.left),
        diameterOfBinaryTree(root.right)),right+left);



    }
    int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.max(left,right)+1;

    }


    int result = 0;

    /**
     * 只需要一个深度递归
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return result;
    }

    public int diameter(TreeNode root) {
        if(root == null)
            return 0;

        int left = diameter(root.left);
        int right = diameter(root.right);
        result = Math.max(result, left + right);

        return Math.max(left, right) + 1;
    }
}
