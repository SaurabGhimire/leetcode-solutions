package neetcode150.backTracking;

class Permutations {
    // 46. Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
    // Input: nums = [1,2,3]
    // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    public static void main(String[] args) {
        List<List<Integer>> permutations = permute(new int[]{1,2,3});
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(nums, curr, list, used);
        return list;
    }

    public void backTrack(int[] nums, List<Integer> curr, List<List<Integer>> list, boolean[] used){
        if(curr.size() == nums.length){
            list.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            curr.add(nums[i]);
            used[i] = true;
            backTrack(nums, curr, list, used);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}