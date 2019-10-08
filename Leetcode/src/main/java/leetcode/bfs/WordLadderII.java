package leetcode.bfs;

import java.util.*;

/**
 * @Author: yangxu
 * @Date: 2019/10/3 上午12:17
 */
public class WordLadderII {
    List<List<String>> res = new ArrayList<>();
    int len = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return res;


        TreeNode root = new TreeNode(beginWord);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<String> removeList = new LinkedList<String>();
            for (int k = queue.size(); k > 0; --k) {

                TreeNode treeNode = queue.poll();
                String word = treeNode.val;
                if (word.equals(endWord)) {
                    backTrace(treeNode);
                    continue;
                }
                for (int i = 0; i < word.length(); ++i) {
                    char[] newWord = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        newWord[i] = ch;
                        if (set.contains(String.valueOf(newWord)) && !word.equals(String.valueOf(newWord))) {
                            TreeNode t = new TreeNode(String.valueOf(newWord));
                            t.parent = treeNode;
                            treeNode.childs.add(t);
                            queue.offer(t);
                            removeList.add(String.valueOf(newWord));

                        }
                    }
                }
            }
            set.removeAll(removeList);

        }
        // 不可能存在了
        return res;

    }

    private void backTrace(TreeNode treeNode) {
        int lent = 0;
        LinkedList<String> linkedList = new LinkedList<>();
        while (treeNode != null) {
            linkedList.addFirst(treeNode.val);
            treeNode = treeNode.parent;
            lent++;
        }
        if (lent <= len) {
            res.add(linkedList);
            len = lent;
        }

    }

    class TreeNode {
        public TreeNode(String val) {
            this.val = val;
        }

        String val;
        List<TreeNode> childs = new ArrayList<>();
        TreeNode parent;
    }

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.addAll(Arrays.asList(new String[]{"ted","tex","red","tax","tad","den","rex","pee"}));
        new WordLadderII().findLadders("red", "tax", a);


    }
}
