package neetcode150.dynamicProgramming1d;


public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            // odd length
            count += countSubstrings(i, i, s);
            // even length
            count += countSubstrings(i, i+1, s);
        }
        return count;
    }

    public int countSubstrings(int left, int right, String s){
        int count = 0;
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }

    class Solution {
        public int countSubstrings(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            int count=0;
            for(int i=s.length()-1;i>=0;i--){
                for(int j=i;j<s.length();j++){
                    if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1])){
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
            return count;
        }
    }
}


