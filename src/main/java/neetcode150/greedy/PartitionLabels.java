package neetcode150.greedy;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] alphabets = new int[26];
        for(int i=0;i<s.length();i++){
            int letter = s.charAt(i) - 'a';
            alphabets[letter] = i;
        }
        int end = 0;
        int size = 0;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            int letter = s.charAt(i) -'a';
            end = Math.max(end, alphabets[letter]);
            if(i == end){
                res.add(++size);
                size = 0;
                continue;
            }
            size++;
        }
        return res;
    }
}