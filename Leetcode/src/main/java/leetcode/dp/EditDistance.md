# 72. Edit Distance

tags: 

- leetcode 

- leetcode-hard

- dp

  

## Desc

Given two words *word1* and *word2*, find the minimum number of operations required to convert *word1* to *word2*.

You have the following 3 operations permitted on a word:

1. Insert a character
2. Delete a character
3. Replace a character

**Example 1:**

```
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
```

**Example 2:**

```
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
```


## 描述

这道题让求从一个字符串转变到另一个字符串需要的变换步骤，共有三种变换方式，插入一个字符，删除一个字符，和替换一个字符。



## 思路

### 基础

首先,明确下DP的本质是递归+缓存,递归本质是状态转移方程,以下解法可以递归,思路是一样的.

但是递归时间复杂度太大所以DP,以下解法时间复杂度O(M,N)

假设字符串 a, 共 m 位，从 `a[0]` 到 `a[m-1]`
字符串 b, 共 n 位，从 `b[0]` 到 `b[n-1]`
`d[i-1][j-1]` 表示字符串 `a[0]-a[i-1]` 转换为 `b[0]-b[j-1]` 的编辑距离

**也就是a的前i位,转化为b的前j位的编辑距离.**

那么有如下递归规律（`a[i]` 和 `b[j]` 分别是字符串 a 和 b 的最后一位）：

1. 当 `a[i]` 等于 `b[j]` 时，`d[i][j] = d[i-1][j-1]`, 比如 fxy -> fay 的编辑距离等于 fx -> fa 的编辑距离
2. 当 `a[i]` 不等于 `b[j]` 时，`d[i][j]` 等于如下 3 项的最小值：

- `d[i-1][j]` + 1（a的结尾删除 `a[i]`）， 比如 fxy -> fab 的编辑距离 = fx -> fab 的编辑距离 + 1
- `d[i][j-1]` + 1（a的结尾插入 `b[j]`)， 比如 fxy -> fab 的编辑距离 = fxyb -> fab 的编辑距离 + 1 = fxy -> fa 的编辑距离 + 1
- `d[i-1][j-1]` + 1（将 `a[i]` 替换为 `b[j]`）， 比如 fxy -> fab 的编辑距离 = fxb -> fab 的编辑距离 + 1 = fx -> fa 的编辑距离 + 1

递归边界(也就是dp数组的起始条件)：

1. `a[i][0] = i`, b 字符串为空，表示将 `a[1]-a[i]` 全部删除，所以编辑距离为 i
2. `a[0][j] = j`, a 字符串为空，表示 a 插入 `b[1]-b[j]`，所以编辑距离为 j

总结一下转移方程是:


```

dp[i][j] = / dp[i - 1][j - 1]      if a[i - 1] == b[j - 1]   这里看着点,别什么都+1

           \ min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1   else

```

对于动态规划来说,有了状态转移方程,其实也就没什么了.





```java
/**
     *leetcode.dp
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];

        for (int i = 0; i <dp.length ; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <dp[0].length ; j++) {
            dp[0][j] = j;
        }

        for(int i = 1;i<=word1.length();i++){
            for (int j = 1; j <=word2.length() ; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] =  dp[i-1][j-1] ;
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) +1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
```



### 优化





https://www.dreamxu.com/books/dsa/dp/edit-distance.html?q=