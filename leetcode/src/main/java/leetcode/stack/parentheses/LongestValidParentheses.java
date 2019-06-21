package leetcode.stack.parentheses;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if(s== null || s.length() ==0){
            return 0;
        }
        int res = 0;
        int start = 0;

        char [] cs = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <cs.length ; i++) {
             if(cs[i]=='('){
                 stack.push(i);

             }else {
                 if (stack.empty()) start = i + 1;
                 else {
                     stack.pop();
                     res = stack.empty() ? Math.max(res, i - start + 1) : Math.max(res, i - stack.peek());
                 }
             }
        }

        return  res;

    }

    public static void main(String[] args) {
        new LongestValidParentheses().longestValidParentheses("((()())");
    }


}
