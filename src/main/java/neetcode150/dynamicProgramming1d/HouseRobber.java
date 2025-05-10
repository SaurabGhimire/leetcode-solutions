package neetcode150.dynamicProgramming1d;

// bottom-up with additional space
public class HouseRobber {
    public int rob(int[] nums) {
        int[] temp = new int[nums.length+2];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        for(int i=2;i<temp.length;i++){
            temp[i] += Math.max(temp[i-2], i-3 < 0 ? 0 : temp[i-3]);
        }
        return Math.max(temp[temp.length-1], temp[temp.length-2]);
    }
}

class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        for(int i=0;i<cache.length;i++){
            cache[i]= Integer.MIN_VALUE;
        }
        int first = dfs(0, nums, cache);
        int second = dfs(1, nums, cache);
        return Math.max(first, second);
    }

    public int dfs(int i,int[] nums, int[] cache){
        if(i>=nums.length) return 0;
        if(cache[i]>Integer.MIN_VALUE) return cache[i];
        cache[i] = nums[i] + Math.max(dfs(i+2,  nums, cache), dfs(i+3, nums, cache));
        return cache[i];
    }
}