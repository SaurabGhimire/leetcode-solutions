package neetcode150.dynamicprogrammin2d;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount+1];
        for(int[] m: memo){
            Arrays.fill(m, -1);
        }
        return dfs(0, amount, coins, memo);
    }

    public int dfs(int i, int amount, int[] coins, int[][] memo){
        if(i>=coins.length) return 0;
        if(amount == 0) return 1;
        if(amount<0) return 0;
        for(int k=i;k<coins.length;k++){
            if(memo[k][amount] != -1) continue;
            memo[k][amount] = dfs(i, amount-coins[i], coins, memo) + dfs(i+1, amount, coins, memo);
        }
        return memo[i][amount];
    }
}
