package neetcode150.dynamicProgramming1d;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum() ;
        if (sum%2 != 0) return false;
        Boolean[][] memo = new Boolean[nums.length][sum/2 + 1];
        return dfs(0, 0, sum/2, nums, memo);
    }

    public boolean dfs(int i, int currSum, int sum, int[] nums, Boolean[][] memo){
        if(currSum == sum) return true;
        if(i>=nums.length) return false;
        if(memo[i][currSum]!= null) return memo[i][currSum];
        boolean isValid = dfs(i+1, currSum, sum, nums, memo);
        if(currSum+nums[i] <= sum){
            if(dfs(i+1, currSum+nums[i], sum, nums, memo)) {
                memo[i][currSum] = true;
                return true;
            };
        }
        memo[i][currSum] = isValid;
        return isValid;
    }
}