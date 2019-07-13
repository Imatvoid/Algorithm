package leetcode.slidingwindow;

public class MinimumWindowSubstring {

    public String minWindow(String S, String T) {

        int[] map = new int[128];
        for (char c : T.toCharArray()) map[c]++;
        int counter = T.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        while (end < S.length()) {
            if (map[S.charAt(end++)]-- > 0) counter--; //in t
            while (counter == 0) { //valid
                if (end - begin < d) {
                    d = end - (head = begin);
                }
                map[S.charAt(begin)]++;
                if (map[S.charAt(begin++)] > 0) {
                    counter++;
                }
                //if(map[S.charAt(begin++)]++==0) counter++;  //make it invalid
            }
        }
        return d == Integer.MAX_VALUE ? "" : S.substring(head, head + d);
    }

    public static void main(String[] args) {
        //new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC");
        new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABBC");
    }
}
