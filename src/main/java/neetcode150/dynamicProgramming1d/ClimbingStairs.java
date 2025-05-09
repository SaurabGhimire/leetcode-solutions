package neetcode150.dynamicProgramming1d;

// Top-down approach
public class ClimbingStairs {
    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return dfs(0, n, map);
    }

    public int dfs(int num, int n, Map<Integer, Integer> map){
        if(num>n) return 0;
        if(num==n) return 1;
        if(map.containsKey(num)){
            return map.get(num);
        } 
        int numOfWays = dfs(num+1, n, map) + dfs(num+2, n, map);
        map.put(num, numOfWays);
        return numOfWays;

    }
}