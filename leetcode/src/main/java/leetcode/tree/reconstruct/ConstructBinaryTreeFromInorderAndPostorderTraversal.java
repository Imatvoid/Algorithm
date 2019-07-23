package leetcode.tree.reconstruct;

import leetcode.tree.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        return helper(inorder, postorder, postorder.length - 1, 0, postorder.length - 1);

    }

    TreeNode helper(int[] inorder, int[] postorder, int postorderIndex, int inLeft, int inRight) {

        if (inLeft > inRight) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postorderIndex]);
        int inorderIndex = findInorderIndex(inorder, inLeft, inRight, node.val);
        int rightSize = inRight - inorderIndex;
        node.right = helper(inorder, postorder, postorderIndex - 1, inorderIndex + 1, inRight);
        node.left = helper(inorder, postorder, postorderIndex - rightSize-1, inLeft, inorderIndex - 1);

        return node;

    }

    private int findInorderIndex(int[] inorder, int start, int end, int key) {
        for (int i = start, j = end; i <= j; ++i, --j) {
            if (inorder[i] == key) {
                return i;
            } else if (inorder[j] == key) {
                return j;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
      // new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(new int[]{9,20,3},new int[]{9,3,20});

        new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(new int[]{3,2,1},new int[]{3,2,1});
    }
}
