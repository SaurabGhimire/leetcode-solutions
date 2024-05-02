package neetcode150.arraysAndHashing;

public class ValidAnagram242 {
    public static void main(String[] args) {
        boolean isAnagram = isAnagram("anagram", "nagaram");
        System.out.println("Is Anagram:" +isAnagram);
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] traversed = new int[128];
        for(int i=0;i<s.length();i++){
            int currentChar = s.charAt(i);
            traversed[currentChar]++;
        }
        for(int i=0;i<t.length();i++){
            int currentChar = t.charAt(i);
            if(traversed[currentChar] == 0) return false;
            traversed[currentChar]--;
        }
        return true;
    }
}
