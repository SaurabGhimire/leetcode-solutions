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
}
