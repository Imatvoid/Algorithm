package leetcode.string;

import java.util.Arrays;

public class PermutationInString {

    /**
     * 滑动窗口+hash
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int a[] = new int[26];
        int b[] = new int[26];
        for (char c : s1.toCharArray()) {
            a[c - 'a']++;
        }
        for (int i = 0; i < s2.length() && (i + s1Len-1) <s2.length(); i++) {

            for (int k = i; k < i + s1Len; k++) {
                b[s2.charAt(k) - 'a']++;
            }

            boolean flag = true;
            for (int j = 0; j < a.length; j++) {
                if (a[j] != b[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
            Arrays.fill(b, 0);

        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }

        int s1Len = s1.length();
        int a[] = new int[26];
        int b[] = new int[26];
        for (char c : s1.toCharArray()) {
            a[c - 'a']++;
        }

        // 初始化滑动窗口
        for (int i = 0; i < s1Len; i++) {
            b[s2.charAt(i) - 'a']++;

        }
        if (Arrays.equals(a, b))
            return true;

        for (int i = s1Len; i <s2.length(); i++) {
            b[s2.charAt(i - s1Len) - 'a']--;
            b[s2.charAt(i) - 'a']++;
            if (Arrays.equals(a, b))
                return true;
        }


        return false;


    }


    public static void main(String[] args) {

        System.out.println(new PermutationInString().checkInclusion("ad",
                "ad"));

    }
}
