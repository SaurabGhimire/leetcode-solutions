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
}
