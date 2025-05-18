package neetcode150.dynamicprogrammin2d;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m][n];
        for(int[] x: memo){
            Arrays.fill(x, -1);
        }
        return dfs(0, 0, word1, word2, memo);
    }

    public int dfs(int i, int j, String word1,String word2, int[][] memo){
        if(i>=word1.length() && j>=word2.length()) return 0;
        if(i>=word1.length()) return word2.length() - j;
        if(j>=word2.length()) return word1.length() - i;
        if(memo[i][j] != -1) return memo[i][j];
        if(word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dfs(i+1, j+1, word1, word2, memo);
            return memo[i][j];
        }
        int insertCount = 0;
        int updateCount = 0;
        int deleteCount = 0;
        // insert
        insertCount = 1+ dfs(i, j+1, word1, word2, memo);
        // update
        updateCount = 1+ dfs(i+1, j+1, word1, word2, memo);
        // delete
        deleteCount = 1+dfs(i+1, j, word1, word2, memo);
        memo[i][j] = Math.min(Math.min(insertCount, updateCount), deleteCount);
        return memo[i][j];
    }

    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m+1][n+1];
            for(int i=0;i<=m;i++){
                dp[i][n] = m-i;
            }
            for(int j=0;j<=n;j++){
                dp[m][j] = n-j;
            }
            System.out.println(Arrays.deepToString(dp));
            for(int i=m-1;i>=0;i--){
                for(int j=n-1;j>=0;j--){
                    if(word1.charAt(i) == word2.charAt(j)){
                        dp[i][j] = dp[i+1][j+1];
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]);
                    dp[i][j] = 1+ Math.min(dp[i][j+1], dp[i][j]);
                }
            }
            return dp[0][0];
        }
    }
}