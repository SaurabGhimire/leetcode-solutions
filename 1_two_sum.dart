class Solution {
  List<int> twoSum(List<int> nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums.contains(target - nums[i]) &&
          nums.indexOf(target - nums[i]) != i) {
        return [i, nums.indexOf(target - nums[i])];
      }
    }
    return [];
  }
}

void main() {
  Solution().twoSum([2, 7, 11, 15], 9);
}
