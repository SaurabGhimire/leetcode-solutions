package neetcode150.backTracking;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        String curr = "";
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        if(digits.isEmpty()) return list;
        backTrack(0, digits, list, map, curr);
        return list;
    }

    public void backTrack(int i, String digits, List<String> list, Map<String, String> map, String curr){
        if(i == digits.length()){
            list.add(curr);
            return;
        }
        String letters = map.get(digits.substring(i, i+1));
        for(int j=0;j<letters.length();j++){
            curr = curr + letters.substring(j, j+1);
            backTrack(i+1, digits, list, map, curr);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
}