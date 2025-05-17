package neetcode150.dynamicprogrammin2d;

public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        // 0 - buying, 1 = selling
        int[][] memo = new int[prices.length][2];
        for(int[] m: memo){
            Arrays.fill(m, -1);
        }
        return dfs(0, 0, prices, memo);
    }

    public int dfs(int i, int state, int[] prices, int[][] memo){
        if(i>=prices.length) return 0;
        if(memo[i][state] != -1) return memo[i][state];
        if(state == 0) { 
            // we can buy
            // buy
            memo[i][0] = Math.max(-prices[i] + dfs(i+1, 1, prices, memo), dfs(i+1, 0, prices, memo));
        }
        if(state == 1){
            // we can sell
            int profit = prices[i] + dfs(i+2, 0, prices, memo);
            memo[i][1] = Math.max(profit, dfs(i+1, 1, prices, memo));
        }
        return memo[i][state];
    }
}
