package leetcode.bfs;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        int res = 1;
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()){
            for (int k = queue.size(); k > 0; --k) {
                String word = queue.poll();
                if(word.equals(endWord)) return  res;
                for (int i = 0; i < word.length(); ++i) {
                    char[] newWord = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        newWord[i] = ch;
                        if (set.contains(String.valueOf(newWord)) && !word.equals(String.valueOf(newWord))) {
                            queue.offer(String.valueOf(newWord));
                            set.remove(String.valueOf(newWord));
                        }
                    }
                }
            }
            res++;
        }
        // 不可能存在了
        return  0;

    }


}
