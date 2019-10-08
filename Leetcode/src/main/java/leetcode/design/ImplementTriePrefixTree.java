package leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class ImplementTriePrefixTree {


    public static void main(String[] args) {
        Map<Character, TreeNode> child = new HashMap<>();
        child.put(new Character('c'), null);
        String s = "scadfasdf";
        System.out.println(child.containsKey(s.charAt(1)));

        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true
    }


}

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

class TreeNode {
    // Character c;
    Map<Character, TreeNode> child;
    boolean ended = false;

    public TreeNode(Character c) {
        // this.c = c;
        child = new HashMap<Character, TreeNode>();
    }
}