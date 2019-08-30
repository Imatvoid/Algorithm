`538. Convert BST to Greater Tree`

<https://leetcode.com/problems/convert-bst-to-greater-tree/>

`把二叉搜索树转换为累加树`
<https://leetcode-cn.com/problems/convert-bst-to-greater-tree/>



## 描述

给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

例如：
````
输入: 二叉搜索树:
              5
            /   \
           2     13
````
````
输出: 转换为累加树:
             18
            /   \
          20     13

````



## 思路
中序遍历`[2 5 13]`

要转化为`[20 18 13]`

其实也就是中序序列化后,数组当前项的值修改为当前+后面值的和.

序列化太浪费时间,递归是解决二叉树问题的好方法,逆中序遍历

```java
  int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root ==null){
            return null;
        }
        convertBST(root.right);
        sum+=root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
        
    }
```


