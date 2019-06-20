package leetcode.dp;

import java.util.Arrays;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {

        if (s.length() < k) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i + k <= s.length(); i++) {
            int map[] = new int[26];
            int mask = 0;
            int max_idx = i;
            for (int j = i; j < s.length(); j++) {
                int t = s.charAt(j) - 'a';
                map[t]++;
                if (map[t] < k) mask |= (1 << t);
                else mask &= (~(1 << t));
                if (mask == 0) {
                    max_idx = j;
                    res = Math.max(res, j - i + 1);
                }
            }
            i = max_idx;
        }
        return res;
    }

    public int longestSubstringSlidingWindow(String s, int k) {
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        int max = 0;
        int kinds, start, end;
        int idx, unique, noLessThanK;


        for (kinds = 1; kinds <= 26; kinds++) {
            Arrays.fill(counts, 0);
            start = 0;
            end = 0;
            // 当前已有的字母种类
            unique = 0;
            noLessThanK = 0;
            while (end < str.length) {
                if (unique <= kinds) {
                    idx = str[end] - 'a';
                    if (counts[idx] == 0)
                        unique++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanK++;
                    end++;
                }
                // 已经容纳满足够种类的字母，缩减窗口
                else {
                    idx = str[start] - 'a';
                    if (counts[idx] == k)
                        noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        unique--;
                    start++;
                }
                if (unique == kinds && unique == noLessThanK)
                    max = Math.max(end - start, max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring("baaabcb",3);
    }
}
