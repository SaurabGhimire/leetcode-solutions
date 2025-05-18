package neetcode150.greedy;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = currSum;
        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            currSum = Math.max(num, currSum + num);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
