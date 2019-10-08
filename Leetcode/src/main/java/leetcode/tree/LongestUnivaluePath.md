`687. Longest Univalue Path`

<https://leetcode.com/problems/longest-univalue-path/>

`687. 最长同值路径`

<https://leetcode-cn.com/problems/longest-univalue-path/>

### 描述
给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。

注意：两个节点之间的路径长度由它们之间的边数表示。

示例 1:

输入:
```
              5
             / \
            4   5
           / \   \
          1   1   5
```          
输出:
```
2
```
示例 2:

输入:
```
              1
             / \
            4   5
           / \   \
          4   4   5
```          
输出:
```
2
```
注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。


### 思路

最长同值路径。

递归过程： 从当前节点开始，求左子树同值路径长度，再求右子树同值路径长度。

基线条件，当前节点为空

```java

    private int maxVal = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        this.helper(root, root.val);
        return maxVal;
    }

    /**
     * 查找和父亲节同值的最长单臂路径。
     *
     * @param listNode
     * @param parentVal
     * @return
     */
    private int helper(TreeNode listNode, int parentVal) {
        if (listNode == null) {
            return 0;
        }

        // 一定要走一遍，结果可能在子树。
        int left = helper(listNode.left, listNode.val);
        int right = helper(listNode.right, listNode.val);

        maxVal = Math.max(maxVal, left + right);
        //如果和父节点值不同返回0
        if (listNode.val == parentVal) {
            return Math.max(left, right) + 1;
        }
        return 0;

    }
```
