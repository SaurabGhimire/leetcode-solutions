package neetcode150.bitManipulation;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
                continue;
            }
            set.add(nums[i]);
        }
        for(Integer s: set){
            return s;
        }
        return -1;
    }

    // XOR is associative and commutative
    // 0 ^ x = x
    // x ^ x = 0
    // {a, b, a, b, x} = (a, a, b, b, x) = 0 ^ 0 ^ x = x
    class Solution {
        public int singleNumber(int[] nums) {
            int sum = 0;
            for(int num: nums){
                sum ^= num;
            }
            return sum;
        }
    }
}
