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

    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            dp[nums.length-1] = 1;
            for(int i=nums.length-2;i>=0;i--){
                int max = 1;
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]<=nums[i]) continue;
                    max = Math.max(max, 1 + dp[j]);
                }
                dp[i] = max;
            }
            int max = 0;
            for (int len : dp) {
                max = Math.max(max, len);
            }
            return max;
        }
    }
}
