package leetcode.tree;

public class LowestCommonAncestorOfABinarySearchTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if (Math.min(p.val, q.val) < root.val && Math.max(p.val, q.val) > root.val) {
            return root;
        }
        if (Math.min(p.val, q.val) < root.val && Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return lowestCommonAncestor(root.right, p, q);


    }


    /**
     * 一定改良
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        if (Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;

    }

    /**
     * 非递归 消除尾递归
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }
        while (true) {
            if (root.val > Math.max(p.val, q.val)) root = root.left;
            else if (root.val < Math.min(p.val, q.val)) root = root.right;
            else break;
        }
        return root;


    }
}
