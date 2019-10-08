package leetcode.medium;

public class MinimumPathSum {

    /**
     * dfs超时
     */

    int minCount = Integer.MAX_VALUE;

    public int minPathSum2(int[][] grid) {

        dfs(grid, 0, 0, grid.length, grid[0].length, grid[0][0]);
        return  minCount;

    }

    void dfs(int[][] grid, int i, int j, int m, int n, int count) {

        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) {
            return;
        }
        if (i == m - 1 && j == n - 1) {
            if (count <= minCount) {
                minCount = count;
            }
            return;
        }
        if(i+1<m) {
            dfs(grid, i + 1, j, m, n, count+grid[i + 1][j]);
        }
        if(j+1<n){
            dfs(grid, i , j+1, m, n, count+grid[i][j+1]);
        }

    }


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int [][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i) dp[i][0] = grid[i][0] + dp[i - 1][0];
        for (int j = 1; j < n; ++j) dp[0][j] = grid[0][j] + dp[0][j - 1];

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return  dp[m-1][n-1];

    }



}
