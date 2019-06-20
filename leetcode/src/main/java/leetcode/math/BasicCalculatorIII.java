package leetcode.math;

import java.util.Stack;

public class BasicCalculatorIII {


    /**
     * 加减乘除括号
     *
     * @param s
     * @return
     */
    public int calculate(String s) {

        int n = s.length();
        int res = 0;
        //临时结果
        int cur = 0;
        // 每一个数字
        int num = 0;
        char op = '+';

        for (int i = 0; i < n; i++) {

            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            }
            // 括号的情况  调用递归
            else if (s.charAt(i) == '(') {
                int j = i;
                int cnt = 0;
                for (; i < n; i++) {

                    if (s.charAt(i) == '(') {
                        cnt++;
                    }
                    if (s.charAt(i) == ')') {
                        cnt--;
                    }
                    if (cnt == 0) {
                        break;
                    }
                }

                num = calculate(s.substring(j + 1, i));
            }

            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/' ||
                    i == n - 1) {

                switch (op) {
                    case '+':
                        cur += num;
                        break;
                    case '-':
                        cur -= num;
                        break;
                    case '*':
                        cur *= num;
                        break;
                    case '/':
                        cur /= num;
                        break;
                }


                if (s.charAt(i) == '+' || s.charAt(i) == '-' || i == n - 1) {
                    res += cur;
                    cur = 0;
                }
                num = 0;
                op = s.charAt(i);


            }

        }

        return res;
    }


    /**
     * 加减乘除括号 "(1+(4+5+2)-3)+(6+8)"
     *
     * @param s
     * @return
     */
    public int calculateStack(String s) {

        int n = s.length();
        int res = 0;
        //临时结果
        int cur = 0;
        // 每一个数字
        int num = 0;
        char op = '+';
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            }
            // 括号的情况  调用递归
            else if (s.charAt(i) == '(') {

                stack.push(res);
                res = 0;

            } else if (s.charAt(i) == ')') {

                res += num;
                num = 0;
                res += stack.pop();
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/' ||
                    i == n - 1) {

                switch (op) {
                    case '+':
                        cur += num;
                        break;
                    case '-':
                        cur -= num;
                        break;
                    case '*':
                        cur *= num;
                        break;
                    case '/':
                        cur /= num;
                        break;
                }


                if (s.charAt(i) == '+' || s.charAt(i) == '-' || i == n - 1) {
                    res += cur;
                    cur = 0;
                }
                num = 0;
                op = s.charAt(i);


            }

        }

        return res;
    }

    public static void main(String[] args) {
        new BasicCalculatorIII().calculateStack("(1+(4+5+2)-3)+(6+8)");
    }
}
