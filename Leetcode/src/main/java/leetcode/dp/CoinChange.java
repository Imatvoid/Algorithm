package leetcode.dp;

import java.util.Arrays;

public class CoinChange {


    public static void main(String[] args) {
        new CoinChange().coinChange(new int[]{2}, 3);
    }

    /**
     * dp 自底向上
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new  int [amount+1];
        dp[0]=0;
        for (int i = 1; i <=amount ; i++) {
            dp[i]=i+1;
        }

        Arrays.sort(coins);

        for (int i = 1; i <=amount ; i++) {
            for (int j = 0; j <coins.length ; j++) {
                if(i-coins[j]>=0 && dp[i-coins[j]]!= i-coins[j]+1){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return  dp[amount]==(amount+1) ? -1 : dp[amount];

    }

    /**
     *
     * dfs+记忆数组   自顶向下
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeRecusion(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        return coinChangeDFS(coins, amount, memo);
    }

    int coinChangeDFS(int[] coins, int rem, int[] memo) {
        if (rem < 0) return -1;
        // 这里要用固定值 不能用target target会变
        if (rem == 0) return 0;
        if (memo[rem] < Integer.MAX_VALUE) return memo[rem];
        for (int i = 0; i < coins.length; ++i) {
            int tmp = coinChangeDFS(coins, rem - coins[i], memo);
            if (tmp >= 0) memo[rem] = Math.min(memo[rem], tmp + 1);
        }
        return memo[rem] = (memo[rem] == Integer.MAX_VALUE) ? -1 : memo[rem];
    }


}
