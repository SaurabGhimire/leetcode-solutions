package neetcode150.dynamicProgramming1d;

// bottom-up with additional space
public class HouseRobber {
    public int rob(int[] nums) {
        int[] temp = new int[nums.length+2];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        for(int i=2;i<temp.length;i++){
            temp[i] += Math.max(temp[i-2], i-3 < 0 ? 0 : temp[i-3]);
        }
        return Math.max(temp[temp.length-1], temp[temp.length-2]);
    }
}
