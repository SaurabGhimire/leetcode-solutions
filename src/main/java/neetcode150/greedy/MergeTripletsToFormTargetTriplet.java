package neetcode150.greedy;

public class MergeTripletsToFormTargetTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<triplets.length;i++){
            Set<Integer> curr = new HashSet<>();
            boolean isValid = true;
            for(int j=0;j<triplets[0].length;j++){
                if(triplets[i][j] > target[j]) {
                    isValid = false;
                    break;
                };
                if(triplets[i][j] == target[j]) {
                    curr.add(j);
                }
            }
            if(isValid){
                set.addAll(curr);
            }
        }
        return set.size() == target.length;
    }
}