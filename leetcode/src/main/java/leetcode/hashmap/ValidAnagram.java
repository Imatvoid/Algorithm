package leetcode.hashmap;

public class ValidAnagram {


    /**
     * 拿数组当hash表 ,字母 =》 对应次数
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        // 一共26个字母
        int[] alphabet = new int[26];
        //s.charAt(i) - 'a' 这也算一个小点
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;

    }
}
