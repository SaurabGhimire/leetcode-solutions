package neetcode150.dynamicProgramming1d;


public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int startingIndex =0;
        int length = 0;
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(s.charAt(i) == s.charAt(j) && (j-i<=2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(j-i+1 >= length){
                        startingIndex = i;
                        length = j-i+1;
                    }
                }
            }
        }
        return s.substring(startingIndex,startingIndex + length);
    }
}
