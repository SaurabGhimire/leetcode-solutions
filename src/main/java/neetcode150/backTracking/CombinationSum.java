package neetcode150.backTracking;

public class CombinationSum {
    public static void main(String[] args) {
        // candidates = [2,3,6,7], target = 7
        int[] candidates = {2,3,6,7};
        combinationSum(candidates, 7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(0, target, candidates, subset, list); 
        return list;
    }

    public void dfs(int i, int target, int[] candidates, List<Integer> subset, List<List<Integer>> list){
        if(i>= candidates.length || target<0) return;
        if(target == 0){
            list.add(new ArrayList<>(subset));
            return;
        }
        subset.add(candidates[i]);
        dfs(i, target - candidates[i], candidates, subset, list );
        subset.remove(subset.size() - 1);
        dfs(i+1, target, candidates, subset, list);
    }
}