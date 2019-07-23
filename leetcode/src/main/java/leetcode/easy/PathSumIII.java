package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res=0;

    public int pathSum(TreeNode root, int sum) {

        List<Integer> tempList = new ArrayList<Integer>();

        dfs(root,sum,0,tempList);

        return  res;

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

            List<Integer> tempList2 = new ArrayList<Integer>();
            tempList2.addAll(tempList);

            while (tempList2.size()>=1){

                if(sum == now) {
                    res++;
                }
                now -= tempList2.remove(0);

            }

            tempList.remove(index-1);



        }
    }
}
