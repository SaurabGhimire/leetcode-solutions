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