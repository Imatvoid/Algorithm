20. Valid Parentheses

<https://leetcode.com/problems/valid-parentheses/>

20. 有效的括号

<https://leetcode-cn.com/problems/valid-parentheses/>

## 描述

给定一个只包括 `'('，')'，'{'，'}'，'['，']'`的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。   
左括号必须以正确的顺序闭合。   
注意空字符串可被认为是有效字符串。     

示例 1:
```
输入: "()"
输出: true
```
示例 2:
```
输入: "()[]{}"
输出: true
```
示例 3:
```
输入: "(]"
输出: false
```
示例 4:
```
输入: "([)]"
输出: false
```
示例 5:
```
输入: "{[]}"
输出: true
```


## 思路

典型的使用栈的问题

```java
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
```