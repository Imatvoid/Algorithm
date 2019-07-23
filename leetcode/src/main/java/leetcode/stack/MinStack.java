package leetcode.stack;

import java.util.Stack;

public class MinStack {


    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> stackMin = new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if(stackMin.isEmpty()){
            stackMin.push(x);
            return;
        }
        if(stackMin.peek()>x){
                stackMin.push(x);
        }else{
            stackMin.push(stackMin.peek());
        }


    }

    public void pop() {
        stack.pop();
        stackMin.pop();
    }

    public int top() {
        return  stack.peek();
    }

    public int getMin() {
       return  stackMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


/**
 * 优化空间复杂度到O(1)
 */
class MinStackOptimize {


    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> stackMin = new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStackOptimize() {

    }

    public void push(int x) {
        stack.push(x);
        if(stackMin.isEmpty()){
            stackMin.push(x);
            return;
        }
        if(stackMin.peek()>x){
            stackMin.push(x);
        }else{
            stackMin.push(stackMin.peek());
        }


    }

    public void pop() {
        stack.pop();
        stackMin.pop();
    }

    public int top() {
        return  stack.peek();
    }

    public int getMin() {
        return  stackMin.peek();
    }
}
