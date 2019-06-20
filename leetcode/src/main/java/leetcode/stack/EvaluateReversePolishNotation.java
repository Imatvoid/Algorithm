package leetcode.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {



     public int evalRPN(String[] tokens) {
     int a,b;
     	Stack<Integer> S = new Stack<Integer>();
     	for (String s : tokens) {
     		if(s.equals("+")) {
     			S.add(S.pop()+S.pop());
     		}
     		else if(s.equals("/")) {
     			b = S.pop();
     			a = S.pop();
     			S.add(a / b);
     		}
     		else if(s.equals("*")) {
     			S.add(S.pop() * S.pop());
     		}
     		else if(s.equals("-")) {
     			b = S.pop();
     			a = S.pop();
     			S.add(a - b);
     		}
     		else {
     			S.add(Integer.parseInt(s));
     		}
     	}
     	return S.pop();
     }
    public int evalRPN2(String[] tokens) {
        int[] ls = new int[tokens.length/2+1];
        int index = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    ls[index - 2] = ls[index - 2] + ls[index - 1];
                    index--;
                    break;
                case "-":
                    ls[index - 2] = ls[index - 2] - ls[index - 1];
                    index--;
                    break;
                case "*":
                    ls[index - 2] = ls[index - 2] * ls[index - 1];
                    index--;
                    break;
                case "/":
                    ls[index - 2] = ls[index - 2] / ls[index - 1];
                    index--;
                    break;
                default:
                    ls[index++] = Integer.parseInt(token);
                    break;
            }
        }
        return ls[0];
    }
}
