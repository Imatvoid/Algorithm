package leetcode.tree.BST;

import leetcode.tree.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length ==0){
            return  null;
        }

       return build(nums,0,nums.length-1);

    }

         TreeNode build(int [] nums, int left, int right){
         if(left>right){
             return null;
         }
         int mid = left +  (right-left)/2;
         TreeNode root = new TreeNode(nums[mid]);
         root.left = build(nums,left,mid-1);
         root.right = build(nums,mid+1,right);
         return  root;

     }

    TreeNode build2(int [] nums, int left, int right){
        // 这里没有等于
        if(left<=right) {
            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = build2(nums, left, mid - 1);
            root.right = build2(nums, mid + 1, right);
            return root;
        }else {
            return  null;
        }

    }

    public static void main(String[] args) {


        new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(new int[]{-10,-3,0,5,9});

    }
}
