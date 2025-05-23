package neetcode150.dynamicProgramming1d;

// Bottom-up approach
public class MinConstClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] tempCost = new int[cost.length+1];
        for(int i=0;i<cost.length;i++){
            tempCost[i] = cost[i];
        }
        for(int i=cost.length-3;i>=0;i--){
            cost[i] = Math.min(cost[i]+cost[i+1], cost[i] + cost[i+2]);
        }
        return Math.min(cost[0], cost[1]);
    }
}

// Memoization approach
class Solution {
    int[] memo;
    
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }
    
    private int dfs(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        memo[i] = cost[i] + Math.min(dfs(cost, i + 1),
                                     dfs(cost, i + 2));
        return memo[i];
    }
}