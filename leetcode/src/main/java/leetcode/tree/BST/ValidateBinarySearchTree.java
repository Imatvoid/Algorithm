package leetcode.tree.BST;

import leetcode.tree.TreeNode;

public class ValidateBinarySearchTree {



    /**
     * 递归
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long low, long high) {
        if (root == null) return true;
        if (root.val <= low || root.val >= high) return false;
        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }

    // 如果
}
