package leetcode.tree.reconstruct;

import leetcode.tree.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderIndex, int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        TreeNode node = new TreeNode(preorder[preorderIndex]);
        int inorderIndex = findInorderIndex(inorder, inLeft, inRight, preorder[preorderIndex]);
        int leftTreeSize = inorderIndex - inLeft;
        node.left = buildTree(preorder, inorder, preorderIndex + 1, inLeft, inorderIndex - 1);
        node.right = buildTree(preorder, inorder, preorderIndex + leftTreeSize + 1, inorderIndex + 1, inRight);
        return node;
    }

    private int findInorderIndex(int[] inorder, int start, int end, int key) {
        for (int i = start, j = end ;i <= j; ++i, --j) {
            if (inorder[i] == key) {
               return i;
            } else if (inorder[j] == key) {
                return j;
            }
        }

        return -1;
    }

}
