package neetcode150.dynamicProgramming1d;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length+1];
        int maxLength = 0;
        return dfs(0, -1, nums, memo);
    }

    public int dfs(int i, int prevIndex, int[] nums, Integer[][] memo){
        if(i == nums.length) return 0;
        if(memo[i][prevIndex+1] != null) return memo[i][prevIndex+1];
        int length = dfs(i+1, prevIndex, nums, memo);
        if(prevIndex == -1 || nums[i] > nums[prevIndex]){
            length = Math.max(length, 1+dfs(i+1, i, nums, memo));
        }
        memo[i][prevIndex+1] = length;
        return length;
    }
}
