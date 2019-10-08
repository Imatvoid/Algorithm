`208. Implement Trie (Prefix Tree)`

<https://leetcode.com/problems/implement-trie-prefix-tree/>

`208. 实现 Trie (前缀树)`

<https://leetcode-cn.com/problems/implement-trie-prefix-tree/>

## 描述
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:
```
Trie trie = new Trie();

trie.insert("apple");  
trie.search("apple");   // 返回 true   
trie.search("app");     // 返回 false  
trie.startsWith("app"); // 返回 true  
trie.insert("app");   
trie.search("app");     // 返回 true  
```
说明:  

你可以假设所有的输入都是由小写字母 a-z 构成的。   
保证所有输入均为非空字符串。


## 思路

定义如下Treenode
```java
class TreeNode {
    // Character c;
    Map<Character, TreeNode> child;
    boolean ended = false;

    public TreeNode(Character c) {
        // this.c = c;
        child = new HashMap<Character, TreeNode>();
    }
}

```

```java
class Trie {
    TreeNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TreeNode(null);
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] cs = word.toCharArray();
        TreeNode node = root;
        for (char c : cs) {
            if (node.child.containsKey(c)) {
                node = node.child.get(c);
                continue;
            }
            TreeNode temp = new TreeNode(c);
            node.child.put(c, temp);
            node = temp;
        }
        if (node != root) {
            node.ended = true;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] cs = word.toCharArray();
        TreeNode node = root;
        for (char c : cs) {
            if (!node.child.containsKey(c)) {
                return false;
            }
            node = node.child.get(c);

        }
        if (node != root && node.ended) {
            return true;
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] cs = prefix.toCharArray();
        TreeNode node = root;
        for (char c : cs) {
            if (!node.child.containsKey(c)) {
                return false;
            }
            node = node.child.get(c);
        }
        if (node != root) {
            return true;
        }
        return false;
    }
}


````
