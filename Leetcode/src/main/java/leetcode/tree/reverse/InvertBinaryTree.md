
`226. Invert Binary Tree`

<https://leetcode.com/problems/invert-binary-tree/>

`226. 翻转二叉树`

<https://leetcode-cn.com/problems/invert-binary-tree/>

## 描述

翻转一棵二叉树。

示例：

输入：
```
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```
输出：
```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

## 思路
递归

递归流程:先递归反转左子树，再右子树。

再将当前节点的左右子树交换。

基线条件:当前节点为空.



```java
   /**
     * 递归写法
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        TreeNode temp = left;
        root.left = right;
        root.right = temp;

        return root;
    }
```

