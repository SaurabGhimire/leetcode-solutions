package neetcode150.backTracking;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, list, 0, curr, 0);
        return list;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> list, int i, List<Integer> curr, int currentSum){
        // note changing the order is not the same for checking the following two conditions 
        if(target == currentSum){
            list.add(new ArrayList<>(curr));
            return;
        }
        if(currentSum>target || i >= candidates.length) return;
        curr.add(candidates[i]);
        currentSum = currentSum + candidates[i];
        dfs(candidates, target, list, i+1, curr, currentSum);
        currentSum = currentSum - curr.get(curr.size() - 1);
        curr.remove(curr.size() - 1);
        while(i<candidates.length-1 && candidates[i] == candidates[i+1]){i++;}
        dfs(candidates, target, list, i+1, curr, currentSum);
    }
}
