package neetcode150.dynamicprogrammin2d;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] memo = new Boolean[s1.length()+1][s2.length()+1];
        if(s1.length() +s2.length() != s3.length()) return false;
        return dfs(0,0, s1, s2, s3, memo);
        
    }

    public boolean dfs(int i, int j, String s1, String s2, String s3, Boolean[][] memo){
        int k = i+j;
        if(k==s3.length()) return true;
        if(memo[i][j]!= null) return memo[i][j];
        
        if(i<s1.length() && s1.charAt(i) == s3.charAt(k)){
            memo[i][j] = dfs(i+1, j, s1, s2, s3, memo);
            if(memo[i][j]) return true;
        }
        if(j<s2.length() && s2.charAt(j) == s3.charAt(k)){
            memo[i][j] = dfs(i, j+1, s1, s2, s3, memo);
            if(memo[i][j]) return true;
        } 
        memo[i][j] = false;
        return memo[i][j];
    }

    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
            if(s1.length() +s2.length() != s3.length()) return false;
            dp[s1.length()][s2.length()] = true;
            for(int i=s1.length();i>=0;i--){
                for(int j=s2.length();j>=0;j--){
                    if(i<s1.length() && s1.charAt(i) == s3.charAt(i+j)){
                        dp[i][j] = dp[i][j] || dp[i+1][j];
                    }
                    if(j<s2.length() && s2.charAt(j) == s3.charAt(i+j)){
                        dp[i][j] = dp[i][j] || dp[i][j+1];
                    }
                }
            }
            return dp[0][0];
        }
    }
}