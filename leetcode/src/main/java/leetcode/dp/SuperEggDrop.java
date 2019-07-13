package leetcode.dp;

public class SuperEggDrop {

    /**
     * 普通dp解法  O(KN^2)
     *
     * @param K
     * @param N
     * @return
     */
    int superEggDrop(int K, int N) {
        int dp[][] = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        for (int j = 2; j <= K; j++) {
            for (int i = 1; i <= N; i++) {
                dp[i][j] = i;
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1);
                }
            }
        }
        return dp[N][K];
    }


    /**
     * O(KlogN) Time, O(NK) Space
     *
     * @param K
     * @param N
     * @return
     */
    public int superEggDropBetter(int K, int N) {

        int[][] dp = new int[N + 1][K + 1];
        int m = 0;
        while (dp[m][K] < N) {
            ++m;
            for (int k = 1; k <= K; ++k)
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
        }
        return m;

    }
}
