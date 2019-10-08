package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> list = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<Integer> tempList = new ArrayList<Integer>();

        dfs(root,sum,0,tempList);

        return  list;

    }

    void dfs(TreeNode root, int sum,int now,List<Integer> tempList){


        if(root != null){

            tempList.add(root.val);
            int index = tempList.size();
            now = now + root.val;
            if(root.left !=null) {
                dfs(root.left, sum, now,tempList);
            }
            if(root.right !=null) {
                dfs(root.right, sum, now,tempList);
            }

            if(root.left ==null && root.right ==null && sum ==now){
                List<Integer> tempList2 = new ArrayList<Integer>();
                tempList2.addAll(tempList);
                list.add(tempList2);
            }

            tempList.remove(index-1);



        }
    }
}
