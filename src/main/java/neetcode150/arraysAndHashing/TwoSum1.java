package neetcode150.arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] twoSumIndices = twoSum(nums, target);
        System.out.println(Arrays.toString(twoSumIndices));
    }

    // "running check by storing index in a hashmap in each iteration"
    // Summary : Running Iteration in HashMap while dealing with two index
    // using HashMap -> {nums[i] -> i}
    // One pass only TimeComplexity:O(n) SpaceComplexity:O(n)
    // Checks  HashMap.contains(difference)
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[] {i, map.get(diff)};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1,-1};
    }
}
