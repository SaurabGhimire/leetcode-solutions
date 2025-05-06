package neetcode150.backTracking;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        list.add(new ArrayList<>());
        Arrays.sort(nums);
        backTrack(0, nums, curr, list);
        return list;
    }

    public void backTrack(int i,int[] nums, List<Integer> curr, List<List<Integer>> list){
        // base case
        if(i>=nums.length) return;
        curr.add(nums[i]);
        list.add(new ArrayList<>(curr));
        backTrack(i+1, nums, curr, list);
        curr.remove(curr.size() - 1);
        while(i<nums.length-1 && nums[i] == nums[i+1]) i++;
        backTrack(i+1, nums, curr, list);
    }
}