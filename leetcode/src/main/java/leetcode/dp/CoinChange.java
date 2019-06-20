package leetcode.dp;

import java.util.Arrays;

public class CoinChange {


    public static void main(String[] args) {
        new CoinChange().coinChange(new int[]{2}, 3);
    }

    /**
     * leetcode.dp 16ms
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // dp代表1-amount块钱的最小硬币数
        int[] dp = new int[amount + 1];
        // amount 最多由amount个硬币组成  amount+1是max
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        // 初始化为amount+1 如果dp[amount] > amount 说明没有存在的
        return (dp[amount] > amount) ? -1 : dp[amount];


    }


    /**
     * leetcode.dp 8ms
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeSort(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // amount 最多由amount个硬币组成  amount+1是max
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                // 当前1块钱  硬币为2块钱 = -1 没必要继续了
                if (i - coins[j] < 0) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);

            }
        }
        return (dp[amount] > amount) ? -1 : dp[amount];

    }

    /**
     *
     * 递归+记忆数组写法
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

    int coinChangeDFS(int[] coins, int target, int[] memo) {
        if (target < 0) return -1;
        // 这里要用固定值 不能用target target会变
        if (memo[target] < Integer.MAX_VALUE) return memo[target];
        for (int i = 0; i < coins.length; ++i) {

            int tmp = coinChangeDFS(coins, target - coins[i], memo);
            if (tmp >= 0) memo[target] = Math.min(memo[target], tmp + 1);

        }
        return memo[target] = (memo[target] == Integer.MAX_VALUE) ? -1 : memo[target];
    }


}
