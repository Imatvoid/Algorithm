
276. 栅栏涂色

<https://leetcode-cn.com/problems/paint-fence/>

## 描述

有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，每个栅栏柱可以用其中一种颜色进行上色。

你需要给所有栅栏柱上色，并且保证其中相邻的栅栏柱 最多连续两个 颜色相同。然后，返回所有有效涂色的方案数。

注意:
n 和 k 均为非负的整数。

示例:

输入: n = 3，k = 2
输出: 6
解析: 用 c1 表示颜色 1，c2 表示颜色 2，所有可能的涂色方案有:
``````
            柱 1    柱 2   柱 3     
 -----      -----  -----  -----       
   1         c1     c1     c2 
   2         c1     c2     c1 
   3         c1     c2     c2 
   4         c2     c1     c1  
   5         c2     c1     c2
   6         c2     c2     c1
``````

## 思路

用动态规划(DP)，不能有超过连续两根柱子是一个颜色，也就意味着第三根柱子要么根第一个柱子不是一个颜色，要么跟第二根柱子不是一个颜色。如果不是同一个颜色，计算可能性的时候就要去掉之前的颜色，也就是k-1种可能性。

假设`dp[1]`是第一根柱子及之前涂色的可能性数量，`dp[2]`是第二根柱子及之前涂色的可能性数量，则`dp[3]=(k-1)*dp[1] + (k-1)*dp[2]`。

递推式有了，下面再讨论下base情况，所有柱子中第一根涂色的方式有k中，第二根涂色的方式则是k*k，因为第二根柱子可以和第一根一样。

State：dp[i] // 代表粉刷到第i个桩子总共有多少种刷法

由题目可以知道，最多有两个相邻的栅栏可以涂相同的颜色。
则主要思想是，如果前两根栅栏颜色相同，则第三根栅栏的颜色不能跟前两根的栅栏颜色相同，若是前两根栅栏颜色不同，则第三根栅栏颜色随便涂。综合的思想就是，第三根栅栏或者与第一根栅栏的颜色不同，或者与第二根的栅栏颜色不同。
（即，包括了，可以与前两个栅栏的颜色都不同，与第一根栅栏颜色不同时，可以与第二根相同，与第二根栅栏不同的时候可以与第一根相同）。




```java

  public int numWays(int n, int k) {
       if(n == 0 || k == 0) return 0;
       if(n==1) return k;
      
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k * k;
        if(n <= 2){
            return dp[n];
        }
        for(int i = 3; i < n+1; i++){
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }
```