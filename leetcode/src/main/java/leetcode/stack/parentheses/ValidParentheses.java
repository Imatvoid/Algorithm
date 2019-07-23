package leetcode.stack.parentheses;

import java.util.Stack;

public class ValidParentheses {

    Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        char [] cs= s.toCharArray();
        for (int i = 0; i <cs.length ; i++) {
            if(cs[i]=='(' || cs[i] == '{' || cs[i] =='['){
                stack.push(cs[i]);
            }else {
                if(stack.empty()){
                    return false;
                }
                if(cs[i]==')' && stack.peek() =='('){
                    stack.pop();
                }else if(cs[i]=='}' && stack.peek() =='{'){
                    stack.pop();
                }else if(cs[i]==']' && stack.peek() =='['){
                    stack.pop();
                }else{
                    return false;
                }
            }

        }
        return  stack.empty();
    }
}
