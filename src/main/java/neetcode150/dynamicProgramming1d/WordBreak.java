package neetcode150.dynamicProgramming1d;

    
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        return dfs(0, s, wordDict, map);
    }

    public boolean dfs(int startIndex, String s, List<String> wordDict, HashMap<Integer, Boolean> map ){
        if(startIndex == s.length()) {
            return true;
        }
        if(map.containsKey(startIndex)) return map.get(startIndex);
        for(String word: wordDict){
            if(word.length() + startIndex > s.length()) continue;
            String segment = s.substring(startIndex, word.length() + startIndex);
            if(!segment.equals(word)) continue;
            int newIndex = startIndex + word.length();
            if(dfs(newIndex, s, wordDict, map)) {
                map.put(startIndex, true);
                return true;
            }
        }
        map.put(startIndex, false);
        return false;
    }
}