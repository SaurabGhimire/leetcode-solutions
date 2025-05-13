package neetcode150.dynamicProgramming1d;

    

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount + 1];
        int result = dfs(coins, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(int[] coins, int rem, Integer[] memo) {
        if (rem < 0) return Integer.MAX_VALUE;
        if (rem == 0) return 0;
        if (memo[rem] != null) return memo[rem];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, rem - coin, memo);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }
        memo[rem] = min;
        return min;
    }

    // Bottom up approach
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount+1];
            Arrays.fill(dp, amount+1);
            dp[0] = 0;
            for(int i=1;i<=amount;i++){
                for(int j=0;j<coins.length;j++){
                    if(coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }

}
