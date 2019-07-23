---
title: 329. Longest Increasing Path in a Matrix(矩阵中的最长递增路径)
date: 2019-05-13 10:13:32
tags:
- LeetCode-Hard
- LeetCode-DFS
- LeetCode-BFS
- LeetCode-DP
categories:
- LeetCode

---

## Desc

https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

## 描述

给定一个整数矩阵，找出最长递增路径的长度。

对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。

<!--more-->

**示例 1:**

```
输入: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
输出: 4 
解释: 最长递增路径为 [1, 2, 6, 9]。
```

**示例 2:**

```
输入: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
输出: 4 
解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
```



## 大意概括

在矩阵中找一条最长的递增路径,其实也是最长的递减路径.



## DFS + Memorization

### 思路

```java
    int leetcode.dp[][];
    int m;
    int n;
    int [][]dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;


        leetcode.dp= new int[m][n];
        int res =1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res = Math.max(res, leetcode.dfs(matrix, i, j));
            }
        }
        return  res;

    }

    int leetcode.dfs(int[][] matrix, int i, int j){
        if(leetcode.dp[i][j]!=0){
            return leetcode.dp[i][j];
        }
        int mx =1;

        for (int[]  a : dirs) {
            int x = i + a[0], y = j + a[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] >= matrix[i][j]) continue;
            int len = 1 + leetcode.dfs(matrix, x, y);
            mx = Math.max(mx, len);
        }
        leetcode.dp[i][j] = mx;
        return mx;

    }


    public static void main(String[] args) {
        new LongestIncreasingPathInAMatrix().longestIncreasingPath(new int[][]{
                 {3,4,5},{3,2,6},{2,2,1}
        });
    }
```









## BFS + Memorization



```java
int leetcode.dp[][];
    int m;
    int n;
    int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    int res =1;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        leetcode.dp= new int[m][n];
        bfs(matrix);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j ) {
                System.out.print(leetcode.dp[i][j] + " ");
            }
            System.out.println();
        }

        return  res;
    }

    void bfs(int[][] matrix){
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j ) {
                if (leetcode.dp[i][j] > 0) continue;
                LinkedList<int []> queue = new  LinkedList<int []>();
                queue.addFirst(new int[]{i,j});
                int cnt = 1;
                leetcode.dp[i][j]=1;
                while (queue.size()>0) {
                    ++cnt;
                    int len = queue.size();
                    for (int k = 0; k < len; ++k) {
                        int[] t = queue.removeLast();
                        for (int[] dir : dirs) {
                            int x = t[0] + dir[0], y = t[1] + dir[1];
                            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[t[0]][t[1]] || cnt <= leetcode.dp[x][y]) continue;
                            leetcode.dp[x][y] = cnt;
                            res = Math.max(res, cnt);
                            queue.addFirst(new int[]{x, y});
                        }
                    }
                }
            }
        }
    }
```

## 

## 纯DP解法(等待补充)





## 参考

[http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-329-longest-increasing-path-in-a-matrix/](