`110. Balanced Binary Tree`

<https://leetcode-cn.com/problems/balanced-binary-tree/>

`110. 平衡二叉树`

<https://leetcode.com/problems/balanced-binary-tree/>

## 描述

给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]
```
    3
   / \
  9  20
    /  \
   15   7
```   
返回 true 。

示例 2:

给定二叉树 `[1,2,2,3,3,null,null,4,4]`
```
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```

## 思路
递归比较深度.

```java
public class BalancedBinaryTree {
    
    boolean res = true;
    public boolean isBalanced(TreeNode root) {

        countDepth(root);
        return res;


    }
    int countDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = countDepth(root.left);
            int right = countDepth(root.right);
            if(left-right>1 || right -left>1){
                res =false;
            }
            return 1 + Math.max(left, right);
        }

    }
}

```


