package neetcode150.intervals;

public class MeetingRoomsII {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for(int i=0;i<intervals.size();i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int res=0, count=0, left=0, right=0;
        while(left<intervals.size()){
            if(start[left] < end[right]){
                left++;
                count++;
            } else{
                right++;
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}