package neetcode150.backTracking;

public class Subsets {
    public static void main(String[] args) {
        List<List<Integer>> subsetResults = subsets("anagram", "nagaram");
        System.out.println("Is Anagram:" +subsetResults);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(0, nums, subset, list);
        return list;
    }

    public void dfs(int index, int[] nums, List<Integer> subset, List<List<Integer>> list){
        if(index >= nums.length){
            list.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(index+1, nums, subset, list);
        subset.remove(subset.size() - 1);
        dfs(index+1, nums, subset, list);
    } 
}