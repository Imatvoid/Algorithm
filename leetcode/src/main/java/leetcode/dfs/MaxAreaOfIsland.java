package leetcode.dfs;

public class MaxAreaOfIsland {
    // 递归
    int res = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int t = helper(grid, i, j);
                    if (t > res) res = t;

                }

            }

        }
        return res;

    }

    int helper(int[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
            return 0;
        }
        if (grid[i][j] == 1) {
            //marked visited;
            grid[i][j] = -1;
            return 1 + helper(grid, i + 1, j) +
                    helper(grid, i, j + 1) +
                    helper(grid, i - 1, j) +
                    helper(grid, i, j - 1);
        }
        return 0;
    }

    int count = 0;
    public int maxAreaOfIslandII(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    dfs(grid, i, j, m, n);
                    max = Math.max(count, max);
                }
            }
        }
        return max;
    }

    // 一种DFS
    private void dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1) {
            return;
        }
        //marked visited;
        grid[i][j] = -1;
        count++;
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i, j - 1, m, n);
    }


}
