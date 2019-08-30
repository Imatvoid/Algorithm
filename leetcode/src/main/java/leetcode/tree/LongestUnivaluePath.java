package leetcode.tree;

public class LongestUnivaluePath {

    private int maxVal = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        this.helper(root, root.val);
        return maxVal;
    }

    /**
     * 查找和父亲节同值的最长单臂路径。
     *
     * @param node
     * @param parentVal
     * @return
     */
    private int helper(TreeNode node, int parentVal) {
        if (node == null) {
            return 0;
        }

        // 一定要走一遍，结果可能在子树。
        int left = helper(node.left, node.val);
        int right = helper(node.right, node.val);

        maxVal = Math.max(maxVal, left + right);
        //如果和父节点值不同返回0
        if (node.val == parentVal) {
            return Math.max(left, right) + 1;
        }
        return 0;

    }
}
