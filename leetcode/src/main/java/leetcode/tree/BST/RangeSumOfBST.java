package leetcode.tree.BST;

import leetcode.tree.TreeNode;

public class RangeSumOfBST {

    int res = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {

        search(root,L,R);
        return res;

    }

    public void search(TreeNode root, int L, int R) {
        if(root==null){
            return;
        }
        if(root.val>=L && root.val<=R ){
            res+=root.val;
        }

        //如果这个值比L大,说明他的左子树里可能有我需要的,我去搜索左子树,
        if(root.val >L){
            search(root.left,L,R);
        }
        //如果这个值比R小,说明他的右子树里可能有我需要的,我去搜索右子树,
        if(root.val <R){
            search(root.right,L,R);
        }

    }
}
