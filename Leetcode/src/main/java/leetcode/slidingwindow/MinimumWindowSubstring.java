package leetcode.slidingwindow;

public class MinimumWindowSubstring {
    /**
     * o(n)
     *
     * @param S
     * @param T
     * @return
     */
    public String minWindow(String S, String T) {
        if (S == null || S.isEmpty() || T == null || T.isEmpty() || S.length() < T.length()) return "";

        int i = 0, j = 0;
        int[] Tmap = new int[128];
        int[] Smap = new int[128];
        for (int k = 0; k < T.length(); k++) {
            Tmap[T.charAt(k)]++;
        }
        int found = 0;
        int length = Integer.MAX_VALUE;
        String res = "";
        while (j < S.length()) {

            if (Tmap[S.charAt(j)] > 0) {
                Smap[S.charAt(j)]++;
                if (Smap[S.charAt(j)] <= Tmap[S.charAt(j)]) {
                    found++;
                }

                while (found == T.length()) {
                    if (j - i + 1 < length) {
                        length = j - i + 1;
                        res = S.substring(i, j + 1);
                    }
                    if (Tmap[S.charAt(i)] > 0) {
                        Smap[S.charAt(i)]--;
                        if (Smap[S.charAt(i)] < Tmap[S.charAt(i)]) {
                            found--;
                        }
                    }
                    i++;
                }
            }
            j++;

        }
        return res;
    }

    public static void main(String[] args) {
        new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABBC");
    }

    /**
     * time limit
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
        if (s == null || s.length() == 0 || t == null || s.length() < t.length()) {
            return "";
        }

        int start = 0;
        int end = 0;

        String res = "";

        int[] tmap = map(t);
        while (end < s.length()) {

            int[] mmap = map(s.substring(start, end + 1));
            if (contains(mmap, tmap)) {
                if (res.equals("")) {
                    res = s.substring(start, end + 1);
                } else {
                    res = res.length() <= s.substring(start, end + 1).length() ? res : s.substring(start, end + 1);
                }
                start++;
            } else {
                end++;
            }

        }
        return res;

    }


    int[] map(String s) {
        int[] map = new int[128];
        for (char c : s.toCharArray()) {
            map[c - 'A']++;
        }
        return map;

    }

    boolean contains(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] - b[i] < 0) {
                return false;
            }
        }
        return true;
    }


}
