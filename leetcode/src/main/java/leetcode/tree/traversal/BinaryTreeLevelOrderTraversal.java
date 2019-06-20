package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {



    /**
     * 二叉树层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res =  new ArrayList<List<Integer>>();
        if(root ==null){
            return   res;
        }
        Queue<TreeNode> queue  = new LinkedList<TreeNode>();
        // offer 更好，但在这里一样。容量无限
        queue.add(root);
        while (!queue.isEmpty()){
            // 这里也算一个小点。
            int levelNum = queue.size();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                temp.add(queue.poll().val);
            }
            res.add(temp);
        }

          return res;


    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.addFirst(subList);
        }
        return wrapList;
    }
}
