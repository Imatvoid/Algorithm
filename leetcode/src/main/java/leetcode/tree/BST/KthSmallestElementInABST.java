package leetcode.tree.BST;

import leetcode.tree.TreeNode;

import java.util.LinkedList;

public class KthSmallestElementInABST {

    int res;
    int count;


    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrder(root);
        return res;

    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        inOrder(root.right);


    }

    /**
     * 中序列非递归
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest2(TreeNode root, int k) {
        int count = k;

        if(root == null){
            return -1;
        }

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            // 一直走到最左端，直到left为null
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.poll();
            count--;
            if (cur != null) {
                if(count ==0){
                    return cur.val;
                }

                stack.push(cur.right);
            }
        }

        return -1;

    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(4);
        TreeNode left = new TreeNode(1);
        left.right = new TreeNode(2);
        root.left = left;
        new KthSmallestElementInABST().kthSmallest(root, 1);
    }
}
