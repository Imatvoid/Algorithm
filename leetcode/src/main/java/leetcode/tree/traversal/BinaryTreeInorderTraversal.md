`94. Binary Tree Inorder Traversal`
<https://leetcode.com/problems/binary-tree-inorder-traversal/>

`94. 二叉树的中序遍历`
<https://leetcode-cn.com/problems/binary-tree-inorder-traversal/>

## 描述

给定一个二叉树，返回它的中序 遍历。

示例:
````
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
````

## 思路

栈,向左走到底.

```java
 public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
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

            if (cur != null) {
                list.add(cur.val);
                stack.push(cur.right);
            }
        }

        return list;
    }
```
