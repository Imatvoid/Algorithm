package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class KnightProbabilityInChessboard {

    int[][] moves = {{1,2},{1,-2},{-1,2},{-1,-2},{2,-1},{2,1},{-2,-1},{-2,1}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[K+1][N][N];
        return helper(dp, N, K, r, c)/Math.pow(8.0, K);
    }
    private double helper(double[][][] dp, int N, int k, int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) return 0.0;
        if (k == 0) return 1.0;
        if (dp[k][r][c] != 0.0) return dp[k][r][c];
        for (int i = 0; i < 8; i++)
            dp[k][r][c] += helper(dp, N, k-1, r+moves[i][0], c+moves[i][1]);
        return dp[k][r][c];
    }










    // memo + dfs
    static int[][] dirs = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};

    public double knightProbabilityMemo(int N, int K, int r, int c) {
        return dfs(K,r,c,N,new HashMap<>());
    }

    double dfs(int K, int i, int j, int N, Map<String,Double> dp){

        if(i < 0 || j < 0 || i > N-1 || j > N-1)
            return 0.0;
        if(K == 0)
            return 1.0;
        double result = 0.0;
        String position = i + "," + j +  "," + K;
        if(dp.get(position) != null)
            return dp.get(position);
        for(int[] dir : dirs)
            result += dfs(K-1, i+dir[0], j+dir[1], N, dp);

        dp.put(position,result * 0.125);
        return dp.get(position);

    }









    // dfs 超时
    int count = 0;

    public double knightProbabilityDFS(int N, int K, int r, int c) {
        helper(N, r, c, K);
        return (count + 0.0) / Math.pow(8, K);
    }

    void helper(int N, int r, int c, int K) {
        if ((r < 0 || r > N - 1) || (c < 0 || c > N - 1)) {
            return;
        }
        if (K == 0) {
            count++;
            return;
        }
        helper(N,r+1,c+2,K-1);
        helper(N,r+2,c+1,K-1);
        helper(N,r-1,c-2,K-1);
        helper(N,r-2,c-1,K-1);
        helper(N,r+1,c-2,K-1);
        helper(N,r+2,c-1,K-1);
        helper(N,r-1,c+2,K-1);
        helper(N,r-2,c+1,K-1);

    }
}
