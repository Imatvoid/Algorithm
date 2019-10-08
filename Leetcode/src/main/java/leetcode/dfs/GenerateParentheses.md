`22. Generate Parentheses`


<https://leetcode.com/problems/generate-parentheses/>

`22. 括号生成`

<https://leetcode-cn.com/problems/generate-parentheses/>

### 描述
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：
```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```


### 思路

典型dfs.

left代表左括号数量.   

right代表右括号数量.

```java
 List<String> res = new ArrayList<>();
    
   public List<String> generateParenthesis(int n) {

           dfs(n,0,0,"");

           return  res;


    }

    public void dfs(int n , int left,int right,String s){
        if(s.length()==n*2){
            res.add(s);
            return;
        }

        if(left<n){
            dfs(n,left+1,right,s+"(");
        }
        if(right<left){
            dfs(n,left,right+1,s+")");
        }

    }
```
