package neetcode150.dynamicProgramming1d;

public class DecodeWays {
    public int numDecodings(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        return dfs(0, s, map);
    }

    public int dfs(int i, String s, Map<Integer, Integer> map){
        if(i==s.length()) return 1;
        if(s.charAt(i) == '0') return 0; 
        if(map.containsKey(i)) return map.get(i);
        int count = 0;
        count += dfs(i+1, s, map);
        if(i+2<=s.length()){
            String sub = s.substring(i, i+2);
            int val = Integer.valueOf(sub);
            if(9<val && val<=26) {
                count += dfs(i+2, s, map);
            }
        }
        map.put(i, count);
        return count;
    }

    // Bottom up approach 
    class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            int[] dp = new int[n+1];
            dp[n] = 1;
            dp[n-1] = s.charAt(s.length()-1) == '0' ? 0 : 1;
            for(int i=n-2;i>=0;i--){
                if(s.charAt(i) == '0') {
                    dp[i] = 0;
                    continue;
                }
                dp[i] = dp[i+1];
                int val = Integer.valueOf(s.substring(i, i+2));
                if(val>9 && val<=26){
                    dp[i] += dp[i+2];
                }
            }
            return dp[0];
        }
    }   
}
