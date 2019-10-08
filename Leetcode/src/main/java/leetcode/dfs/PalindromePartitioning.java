package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> res = new ArrayList<List<String>>();

    public List<List<String>> partition(String s) {

        if (s.length() == 0) return res;
        dfs(new ArrayList<String>(), 0, s);
        return res;
    }

    public void dfs(List<String> temp, int start, String s) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(temp));
            return;
        }

        for (int i = 1; start + i <= s.length(); i++) {

            String t = s.substring(start, start + i);
            if (isPalin(t)) {
                temp.add(t);
                dfs(temp, start + i, s);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalin(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new PalindromePartitioning().partition("aab");
    }
}
