package leetcode.twopointer;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.equals(" ")) {
            return true;
        }

        int i=0, j=s.length()-1;
        while (i<j) {
            while (i<j && !isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (i<j && !isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            char l = Character.toLowerCase(s.charAt(i));
            char r = Character.toLowerCase(s.charAt(j));

            if (l != r) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    private static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }
}
