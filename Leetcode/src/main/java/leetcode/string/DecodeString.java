package leetcode.string;

import java.util.Stack;

/**
 * @Author: yangxu
 * @Date: 19-7-25 下午11:10
 */
public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> numS = new Stack<>();
        Stack<String> resS = new Stack<>();

        char[] cs = s.toCharArray();
        String res = "";

        for (int i = 0; i < cs.length; i++) {
            if (Character.isDigit(cs[i])) {
                int count = 0;
                while (Character.isDigit(cs[i])) {
                    count = count * 10 + cs[i] - '0';
                    i++;
                }
                // 这里要小心
                i--;
                numS.push(count);
                continue;
            }
            if (cs[i] == '[') {
                resS.push(res);
                res ="";
                continue;
            }
            if (cs[i] == ']' ) {
                StringBuilder sb =new StringBuilder(resS.pop());
                int count = numS.pop();
                while (count>0){
                 count--;
                 sb.append(res);
                }
                res = sb.toString();
                continue;
            }
           res += cs[i];
        }
        return res;

    }

    public static void main(String[] args) {

        new DecodeString().decodeString("3[a2[c]]");

    }


}
