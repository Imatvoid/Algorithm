`145. Binary Tree Postorder Traversal`
<https://leetcode.com/problems/binary-tree-postorder-traversal/>

`后序遍历`

<https://leetcode-cn.com/problems/binary-tree-postorder-traversal/>

## 描述

给定一个二叉树，返回它的 后序 遍历。

示例:
``````
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
``````
进阶: 递归算法很简单，你可以通过迭代算法完成吗？


## 思路

栈

```java
 public List<Integer> postorderTraversal(TreeNode root) {


        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            if (p != null) {
                result.addFirst(p.val);
                stack.push(p.left);
                stack.push(p.right);

            }
        }
        return result;


    }
```