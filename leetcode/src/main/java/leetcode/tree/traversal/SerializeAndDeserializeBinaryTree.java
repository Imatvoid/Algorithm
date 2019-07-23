package leetcode.tree.traversal;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {




    /**
     * 层次遍历
     *
     * @param root
     * @return
     */
    // Encodes a leetcode.tree to a single leetcode.string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val).append(",");
                    queue.add(node.left);
                    queue.add(node.right);

                } else {
                    sb.append("null").append(",");
                }

            }
        }
        return  sb.substring(0,sb.length()-1);

    }

    // Decodes your encoded data to leetcode.tree.
    public TreeNode deserialize(String data) {

        if(data ==null || data.length() ==0){
            return  null;
        }
        String[] tree = data.split(",");

        TreeNode root = new TreeNode(Integer.valueOf(tree[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int i =1;
        while (i<tree.length){
            TreeNode node = queue.poll();
            String left=tree[i];
            String right=tree[i+1];
            if(!left.equals("null")){
                TreeNode lf=new TreeNode(Integer.valueOf(left));
                node.left=lf;
                queue.add(lf);
            }else{
                node.left=null;
            }
            if(!right.equals("null")){
                TreeNode rt=new TreeNode(Integer.valueOf(right));
                node.right=rt;
                queue.add(rt);
            }else{
                node.right=null;
            }
            i+=2;
        }
        return root;


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.right =  new TreeNode(2);
        new SerializeAndDeserializeBinaryTree().serialize(root);
    }
}
