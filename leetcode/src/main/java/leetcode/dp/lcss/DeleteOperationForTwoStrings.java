package leetcode.dp.lcss;

public class DeleteOperationForTwoStrings {


    public int minDistance(String word1, String word2) {

        int max = 0;

        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m + 1][n + 1];

        // 多加了行一列初始化已经完成

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp [i-1][j-1] + 1;
                    if(dp[i][j] > max) max = dp[i][j];
                }else{
                    // 错位比较
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return  m+n-2*max;
    }
}
