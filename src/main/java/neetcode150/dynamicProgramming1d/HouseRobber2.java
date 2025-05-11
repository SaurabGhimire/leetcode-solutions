package neetcode150.dynamicProgramming1d;

// 
public class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] firstArr = new int[nums.length - 1];
        int[] secondArr = new int[nums.length - 1];
        System.arraycopy(nums, 0, firstArr, 0, nums.length-1);
        System.arraycopy(nums, 1, secondArr, 0, nums.length-1);
        return Math.max(robber(firstArr), robber(secondArr));
    }

    public int robber(int[] nums){
        int[] cache = new int[nums.length];
        for(int i=0;i<cache.length;i++){
            cache[i]=-1;
        }
        return Math.max(dfs(0, nums, cache),  dfs(1, nums, cache));
    }

    public int dfs(int i, int[] nums, int[] cache){
        if(i>=nums.length) return 0;
        if(cache[i] > -1) return cache[i];
        cache[i] = nums[i] + Math.max(dfs(i+2, nums, cache),dfs(i+3, nums,cache));
        return cache[i];
    }
}
