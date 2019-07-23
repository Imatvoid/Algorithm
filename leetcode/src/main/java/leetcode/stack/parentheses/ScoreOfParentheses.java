package leetcode.stack.parentheses;

import java.util.Stack;

public class ScoreOfParentheses {

    public int scoreOfParentheses(String S) {
        if(S == null || S.length() == 0) return 0;
        int count = 0;
        int res = 0;
        boolean flag = false;
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(c=='('){
                count++;
                flag = true;
            }
            else{
                if(flag){
                    res += Math.pow(2,count-1);
                    flag = false;
                }
                count--;
            }
        }
        return res;

    }

    public int scoreOfParenthesesStack(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int score = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else if (c == ')') {
                score = stack.pop();
                score = score == 0 ? 1 : 2 * score;
                stack.push(stack.pop() + score);
            }
        }
        return stack.peek();
    }
//    本质
//    S = S.replace(')(', ')+(')
//    S = S.replace('()', '1')
//    S = S.replace('(', '2*(')
    public static void main(String[] args) {
        System.out.println(new ScoreOfParentheses().scoreOfParentheses("()"));
        System.out.println(new ScoreOfParentheses().scoreOfParentheses("()()"));
        System.out.println(new ScoreOfParentheses().scoreOfParentheses("(())"));
        System.out.println(new ScoreOfParentheses().scoreOfParentheses("(()())"));
        System.out.println(new ScoreOfParentheses().scoreOfParentheses("(()(()))"));
    }
}
