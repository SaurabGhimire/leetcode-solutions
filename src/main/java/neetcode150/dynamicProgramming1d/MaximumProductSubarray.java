package neetcode150.dynamicProgramming1d;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int largestProduct = nums[0];
        for(int i=1;i<nums.length;i++){
            int curr = nums[i];
            int p1 = max[i-1] * curr;
            int p2 = min[i-1] * curr;
            max[i] = Math.max(curr, Math.max(p1, p2));
            min[i] = Math.min(curr, Math.min(p1, p2));
            largestProduct = Math.max(max[i], largestProduct);
        }
        return largestProduct;
    }
}