package neetcode150.intervals;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int[] interval = intervals[i];
            if(newInterval == null || interval[1] < newInterval[0]){
                res.add(interval);
            } else if(interval[0] > newInterval[1]){
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if(newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}