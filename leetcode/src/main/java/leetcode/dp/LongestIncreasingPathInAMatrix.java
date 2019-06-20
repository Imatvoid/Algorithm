package leetcode.dp;

public class LongestIncreasingPathInAMatrix {

    int dp[][];
    int m;
    int n;
    int [][]dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;


        dp= new int[m][n];
        int res =1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return  res;

    }

    int dfs(int[][] matrix, int i, int j){
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int mx =1;

        for (int[]  a : dirs) {
            int x = i + a[0], y = j + a[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y);
            mx = Math.max(mx, len);
        }
        dp[i][j] = mx;
        return mx;

    }



    public static void main(String[] args) {
        new LongestIncreasingPathInAMatrix().longestIncreasingPath(new int[][]{
                {3, 4, 5}, {3, 2, 6}, {2, 2, 1}
        });
    }
}
