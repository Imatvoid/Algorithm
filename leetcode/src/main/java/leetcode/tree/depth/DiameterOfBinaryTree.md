`543. Diameter of Binary Tree`

<https://leetcode.com/problems/diameter-of-binary-tree/>

`543. 二叉树的直径`

<https://leetcode-cn.com/problems/diameter-of-binary-tree/>

## 描述
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。

示例 :
给定二叉树
```
          1
         / \
        2   3
       / \     
      4   5    
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
```
注意：两结点之间的路径长度是以它们之间边的数目表示。


## 思路

```java
public class DiameterOfBinaryTree {

    int result = 0;

    /**
     * 只需要一个深度递归
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return result;
    }

    public int diameter(TreeNode root) {
        if(root == null)
            return 0;

        int left = diameter(root.left);
        int right = diameter(root.right);
        //他需要的是长度  1-2-3 长度是2
        result = Math.max(result, left + right);
        // 深度
        return Math.max(left, right) + 1;
    }
}

```


