package neetcode150.binarySearch;

public class SearchInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // find the right most sorted array
        while(nums[right]<nums[left]){
            int mid = (left + right) / 2;
            if(nums[mid]>nums[left]){
                left = mid;
            } else if(nums[mid]<nums[right]){
                right = mid;
            } else {
                break;
            }
        }
        // return the min of the right most sorted array
        return Math.min(nums[left], nums[right]);
    }
}
