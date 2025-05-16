package neetcode150.dynamicprogrammin2d;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i], -1);
        }
        return dfs(text1, text2, 0, 0, memo);
    }

    public int dfs(String text1, String text2, int i, int j, int[][] memo){
        if(i == text1.length() || j == text2.length()) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] = 1+dfs(text1, text2, i+1, j+1, memo);
            return memo[i][j];
        }
        memo[i][j] = Math.max(dfs(text1, text2, i+1, j, memo), dfs(text1, text2, i, j+1, memo));
        return memo[i][j];
    }

    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int row = text1.length()+1;
            int col = text2.length()+1;
            int[][] dp = new int[row][col];
            for(int i=row-2;i>=0;i--){
                for(int j=col-2;j>=0;j--){
                    if(text1.charAt(i) == text2.charAt(j)){
                        dp[i][j] = 1+ dp[i+1][j+1];
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                    }
                }
            }
            return dp[0][0];
        }
    }
}
