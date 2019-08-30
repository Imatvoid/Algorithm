`144. Binary Tree Preorder Traversal`

<https://leetcode.com/problems/binary-tree-preorder-traversal/>

`二叉树先序遍历`

<https://leetcode-cn.com/problems/binary-tree-preorder-traversal/>


## 描述

给定一个二叉树，返回它的 前序 遍历。

 示例:
``````
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]
``````



## 思路

使用栈

```java
 /**
     * 先序列遍历非递归
     * @param root
     * @return
     */
      public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> resList = new LinkedList<Integer>();
            LinkedList<TreeNode> stack =new LinkedList<TreeNode>();
    
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(node != null){
                    resList.add(node.val);
                    stack.push(node.right);
                    stack.push(node.left);
                }
            }
            return  resList;
        }
```


