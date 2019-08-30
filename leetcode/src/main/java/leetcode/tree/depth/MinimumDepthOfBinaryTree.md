
`111. Minimum Depth of Binary Tree`

<https://leetcode.com/problems/minimum-depth-of-binary-tree/>

`111. 二叉树的最小深度`

<https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/>

### 描述

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 `[3,9,20,null,null,15,7]`,
```
    3
   / \
  9  20
    /  \
   15   7
```   
返回它的最小深度  2.


### 思路

求左右子树最小深度。 当其中一个为0的时候返回另一个子树深度+1。

因为类似这个二叉树

```
    3
     \
     20
               
```   
它的最小深度是2,不是1

```java
 class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (left == 0) return right + 1;
            if (right == 0) return left + 1;
            return 1 + Math.min(left, right);
        }

    }
```
