package neetcode150.greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length-1] = true;
        for(int i=nums.length-2;i>=0;i--){
            boolean isValid = false;
            for(int j=0;j<=nums[i];j++){
                if(isValid) break;
                isValid = dp[i+j];
            }
            dp[i] = isValid;
        }
        return dp[0];
    }

    class Solution {
        public boolean canJump(int[] nums) {
            int goal = nums.length-1;
            for(int i=nums.length-1;i>=0;i--){
                if(i+nums[i] >= goal){
                    goal = i;
                }
            }
            return goal == 0;
        }
    }
}