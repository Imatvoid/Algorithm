`101. Symmetric Tree`

<https://leetcode.com/problems/symmetric-tree/>

`101. 对称二叉树`

<https://leetcode-cn.com/problems/symmetric-tree/>


### 描述

给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 `[1,2,2,3,4,4,3]` 是对称的。
```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```
但是下面这个 `[1,2,2,null,3,null,3]` 则不是镜像对称的:
```
    1
   / \
  2   2
   \   \
   3    3
```
说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。


### 思路

二叉树的法门，递归

```java

 public boolean isSymmetric(TreeNode root) {
        if(root ==null) return true;
        return  helper(root.left,root.right);
    }
    public boolean helper(TreeNode left,TreeNode right){

        if(left ==null && right ==null){
            return  true;
        }

        if(left==null && right!=null){
            return false;
        }
        if(right==null && left!=null){
            return false;
        }
        if(right.val!=left.val){
            return false;
        }

        return helper(left.left,right.right)  &&  helper(left.right,right.left);
    }
```