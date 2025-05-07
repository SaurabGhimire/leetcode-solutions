package neetcode150.backTracking;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backTrack(0, s, curr, list);
        return list;
    }

    public void backTrack(int i, String s, List<String> curr, List<List<String>> list){
        if(i>=s.length()){
            list.add(new ArrayList<>(curr));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(isPalindrome(s, i, j)){
                curr.add(s.substring(i, j+1));
                backTrack(j + 1, s, curr, list);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left)!= s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}