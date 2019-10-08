package leetcode.slidingwindow;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int res = 0;

        //至少两个元素
        int[] map = new int[128];
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            if (map[s.charAt(end)] == 0) {
                map[s.charAt(end)]++;
                if (end -start +1  > res) res = end -start +1;
                end ++;
            }else {
                //存在重复
                map[s.charAt(start)]--;
                start++;
            }
        }
       return  res;

    }

    public static void main(String[] args) {
        System.out.println( new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
    }
}
