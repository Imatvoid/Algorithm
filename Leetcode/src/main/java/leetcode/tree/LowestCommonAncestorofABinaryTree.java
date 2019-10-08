package leetcode.tree;


public class LowestCommonAncestorofABinaryTree {


    /**
     * 在当前树搜寻 p/q  节点值是唯一的
     *
     * @param node
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null || node == p || node == q) {
            return node;
        }
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        // 在左右都搜寻到了，返回根节点。
        if (left != null && right != null) {
            return node;
        }
        return left != null ? left : right;
        // 一样的
        //return right!=null?right:left;

    }
}
