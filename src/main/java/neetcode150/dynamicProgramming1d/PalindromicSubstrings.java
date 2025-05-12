package neetcode150.dynamicProgramming1d;


public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            // odd length
            int left = i;
            int right = i;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }
            // even length
            left = i;
            right = i+1;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}
