package leetcode.medium;

public class MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] A, int[] B) {

        int res = 0;

        int m = A.length;
        int n = B.length;

        // 为了处理左上角 在外围要加上一列
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {

                if(A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(dp[i][j], res);
                }else {
                    // 因为是最长公共连续数组，所以在一旦有不等于的地方，要直接=0 不继续传递。
                    dp[i][j] = 0;
                }

            }
        }

        return res;

    }

}



