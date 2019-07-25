package leetcode.bfs;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int res = 0;
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; --k) {
                String word = q.poll();
                if (word.equals(endWord)) return res + 1;
                for (int i = 0; i < word.length(); ++i) {
                    char[] newWord = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        newWord[i] = ch;
                        if (set.contains(String.valueOf(newWord)) && !word.equals(String.valueOf(newWord))) {
                            q.offer(String.valueOf(newWord));
                            set.remove(String.valueOf(newWord));
                        }
                    }
                }
            }
            ++res;
        }
        return 0;
    }

}
