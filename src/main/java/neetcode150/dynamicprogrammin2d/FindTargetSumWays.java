package neetcode150.dynamicprogrammin2d;

public class FindTargetSumWays {
    int offset = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = Arrays.stream(nums).sum();
        if (Math.abs(target) > totalSum) return 0;
        int[][] memo = new int[nums.length][2*totalSum + 1];
        for(int[] m: memo){
            Arrays.fill(m, -1);
        }
        offset = totalSum;
        return dfs(0, 0, nums, memo, target);
    }

    public int dfs(int i, int target, int[] nums, int[][] memo, int res){
        if(i>nums.length) return 0;
        if(i==nums.length) return target == res ?  1: 0;
        if(memo[i][offset + target] != -1) return memo[i][offset + target];
        int count = 0;
        count += dfs(i+1, target+nums[i], nums, memo, res) + dfs(i+1, target-nums[i], nums, memo, res);
        memo[i][offset + target ] = count;
        return count;
    }
}
