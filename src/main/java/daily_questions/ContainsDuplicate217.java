package daily_questions;

import java.util.HashSet;

public class ContainsDuplicate217 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,4,3,2,4,2};
        boolean containsDuplicate = containsDuplicate(arr);
        System.out.println("Contains Duplicate:" + containsDuplicate);
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> traversedNums = new HashSet<>();
        for (int num : nums) {
            if (traversedNums.contains(num)) return true;
            traversedNums.add(num);
        }
        return false;
    }
}
