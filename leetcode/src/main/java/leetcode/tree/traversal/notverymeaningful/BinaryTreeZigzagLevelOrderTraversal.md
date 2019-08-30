`103. Binary Tree Zigzag Level Order Traversal`

<https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/>

`103. 二叉树的锯齿形层次遍历`

<https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/>


## 描述

给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],
``````

    3
   / \
  9  20
    /  \
   15   7
``````
返回锯齿形层次遍历如下：
````
[
  [3],
  [20,9],
  [15,7]
]
````


## 思路

本质还是层序遍历, 只不过偶尔逆序, 用个flag就行. 意义不大

```java
 /**
     * 层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        boolean flag = false;
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.pollLast();
                if (node != null) {
                    if (flag) {
                        list.addFirst(node.val);
                    } else {
                        list.add(node.val);
                    }
                    queue.addFirst(node.left);
                    queue.addFirst(node.right);
                }
            }
            if(list.size()>0) {
                res.add(list);
            }
            flag = !flag;
        }
        return res;

    }
```
