package neetcode150.intervals;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        int[] prev = intervals[0];
        int count = 0;
        for(int i=1;i<intervals.length;i++){
            int[] curr = intervals[i];
            if(prev[1] <= curr[0]){
                list.add(prev);
                prev = curr;
                continue;
            }
            if(prev[1]<=curr[1]){
                list.add(prev);
            } else{
                list.add(curr);
                prev = curr;
            }
            count++;
        }
        return count;
    }
}