173.Binary Search Tree Iterator  

<https://leetcode.com/problems/binary-search-tree-iterator/>

173.二叉搜索树迭代器

<https://leetcode-cn.com/problems/binary-search-tree-iterator/>

## 描述
对二叉搜索树实现迭代器

## 思路

仿照java`ArrayList`的iterator实现。

使用一个底层数组,游标cursor和size

```java

import leetcode.tree.TreeNode;

import java.util.ArrayList;

public class BinarySearchTreeIterator {

    /**
     * Definition for a binary tree listNode.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    static class BSTIterator {

        ArrayList<Integer> elements = new ArrayList<>();
        int size;
        int cursor;

        public BSTIterator(TreeNode root) {
            serialize(root);
            size = elements.size();
            cursor = 0;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return elements.get(cursor++);

        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return cursor < size;
        }

        void serialize(TreeNode root) {
            if (root == null) {
                return;
            }
            serialize(root.left);
            elements.add(root.val);
            serialize(root.right);

        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}

```



	
	
	