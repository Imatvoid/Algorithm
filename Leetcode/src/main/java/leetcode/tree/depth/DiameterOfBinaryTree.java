package leetcode.tree.depth;

import leetcode.tree.TreeNode;

public class DiameterOfBinaryTree {

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
        //他需要的是长度  1-2-3 长度是2
        result = Math.max(result, left + right);
        // 深度
        return Math.max(left, right) + 1;
    }
}
