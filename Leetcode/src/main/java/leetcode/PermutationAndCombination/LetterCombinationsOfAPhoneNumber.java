package leetcode.PermutationAndCombination;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {


    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> res = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        // 边界条件
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        dfs(digits, 0, new StringBuilder());
        return res;
    }

    void dfs(String digits, int start, StringBuilder sb) {
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }

        //  for (int i = start; i < digits.length(); i++) {

        char[] cs = map.get(digits.charAt(start)).toCharArray();
        for (char c : cs) {
            sb.append(c);
            dfs(digits, start + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        // }

    }

    public static void main(String[] args) {
        new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
    }
}
