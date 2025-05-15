package neetcode150.dynamicprogrammin2d;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        for(int j=0;j<n;j++){
            path[m-1][j] = 1;
        }
        for(int i=0;i<m;i++){
            path[i][n-1] = 1;
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                path[i][j] = path[i+1][j] + path[i][j+1];
            }
        }
        return path[0][0];
    }

    class Solution {
        public int uniquePaths(int m, int n) {
            Integer[][] path = new Integer[m][n];
            return dfs(0, 0, path);
        }

        public int dfs(int i, int j, Integer[][] path){
            if(i==path.length-1 && j==path[0].length-1) return 1;
            if(i>=path.length || j>=path[0].length) return 0;
            if(path[i][j] != null) return path[i][j];
            path[i][j] = dfs(i+1, j, path) + dfs(i, j+1, path);
            return path[i][j];
        }
    }
}
