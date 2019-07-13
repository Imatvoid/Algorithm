package leetcode.string;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {

        Stack<String>  stack = new Stack<String>();


        String res = "";
        String temp ="";
        String [] ss = path.split("/");
        for(String s1 : ss){
            if(s1.equals("")||s1.equals(".")){
                continue;
            }
            if(s1.equals("..")){
                if(stack.size()>0) stack.pop();
                continue;
            }
            stack.push(s1);
        }

        while (!stack.isEmpty()){
            res = stack.pop()+temp+res;
            temp = "/";

        }

        return "/"+res;

    }

    public static void main(String[] args) {
        System.out.println( new SimplifyPath().simplifyPath("/home//foo/"));
    }
}
