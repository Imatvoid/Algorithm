package leetcode.easy;

import java.util.Stack;

public class PathSum {


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean exsit = false;

    public boolean hasPathSumRecursion(TreeNode root, int sum) {
        dfs(root,sum,0);
        return  exsit;
    }

    void  dfs(TreeNode root, int sum,int now){

        if(!exsit && root != null){
            now += root.val;
            dfs(root.left,sum,now);
            dfs(root.right,sum,now);
            if(root.left == null && root.right ==null &&  now == sum){
                exsit =true;
            }

        }


    }

    /**
     * iteration
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);

        while (!stack.isEmpty()){

            TreeNode temp = stack.pop();


            if(temp !=null){

                if(temp.left == null && temp.right ==null && temp.val == sum){
                    return  true;
                }


                if(temp.left !=null) {
                    temp.left.val += temp.val;
                    stack.add(temp.left);
                }


                if(temp.right !=null) {
                    temp.right.val += temp.val;
                    stack.add(temp.right);
                }

            }
        }


        return  false;
    }
}
