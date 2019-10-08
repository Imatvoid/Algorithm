# Triangle

tags: 

- leetcode 

- leetcode-leetcode.medium

- dp

  

## Desc

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

```
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
```

The minimum path sum from top to bottom is `11` (i.e., **2** + **3** + **5** + **1** = 11).

**Note:**

Bonus point if you are able to do this using only *O*(*n*) extra space, where *n* is the total number of rows in the triangle.



## 描述

这道题给了我们一个二维数组组成的三角形，让我们寻找一条自上而下的路径，使得路径和最短。每一步可以往下一层临近的节点走.





## 思路

### 前置

[     
       [2`0`],
     [3`0`,4`1`],
   [6`0`,5`1`,7`2`],
  [4`0`,1`1`,8`2`,3`3`]
]

以第3行6 5 7 为例, 
6的来源只有3,   dp[j] = dp[j] + triangle.get(i).get(j);
7的来源只有4,   dp[j] = dp[j - 1] + triangle.get(i).get(j);
5可以来自于3或者4  dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);








```java
  /**
     * DP O(N)
     *
     * @param triangle
     * @return
     */ 
public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int rowSize = triangle.size();
        
        // 最长一行作为数组 
        int dp[] = new int[rowSize];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < rowSize; i++) {
            int colSize = triangle.get(i).size();
           leetcode.dp
            for (int j = colSize - 1; j >= 0; j--) {
                // [1]第一个元素
                if (j == 0) {
                    dp[j] = dp[j] + triangle.get(i).get(j);
                }
                // [2]倒数第一个元素
                else if (j == colSize - 1) {
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                }
                // 其他
                else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
                }
                if (i == rowSize - 1 && dp[j] < res) {
                    res = dp[j];
                }
            }
            // // 打印DP数组 调试
            leetcode.dp
            leetcode.dp
            //    }
            //   System.out.println();
        }


        return res;
    }
```





最开始的不考虑空间的做法

```java
 /**
     * 通用DP
     *
     * @param triangle
     * @return
     */
    public int minimumTotalDP(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int rowSize = triangle.size();

        int dp[][] = new int[rowSize + 1][rowSize + 1];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < rowSize; i++) {
            int colSize = i + 1;
            for (int j = 0; j < colSize; j++) {
                if (j == 0) {
                    dp[i + 1][j + 1] = dp[i - 1 + 1][j + 1] + triangle.get(i).get(j);
                } else if (j == colSize - 1) {
                    dp[i + 1][j + 1] = dp[i - 1 + 1][j - 1 + 1] + triangle.get(i).get(j);
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i - 1 + 1][j + 1], dp[i - 1 + 1][j - 1 + 1]) + triangle.get(i).get(j);
                }

                if (i == rowSize - 1 && dp[i + 1][j + 1] < res) {
                    res = dp[i + 1][j + 1];
                }

            }
        }

        // 打印DP数组 调试
leetcode.dp
leetcode.dp
leetcode.dp
//            }
//            System.out.println();
//
//        }
        return res;


    }

```









