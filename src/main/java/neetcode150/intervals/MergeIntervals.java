package neetcode150.intervals;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> prevList = new ArrayList<>();
        for(int[] interval: intervals){
            prevList.add(interval);
        }
        Collections.sort(prevList, (a,b) -> a[0]-b[0]);
        intervals = prevList.toArray(new int[prevList.size()][]);
        List<int[]> list = new ArrayList<>();
        int[] prev = intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] curr = intervals[i];
            if(prev[1]<curr[0]) {
                list.add(prev);
                prev = curr;
                continue;
            } else{
                prev = new int[]{Math.min(prev[0], curr[0]), Math.max(prev[1], curr[1])};
            }
        }
        if(prev!= null) list.add(prev);
        return list.toArray(new int[list.size()][]);
    }
}