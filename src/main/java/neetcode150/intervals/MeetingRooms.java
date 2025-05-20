package neetcode150.intervals;

public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        for(int i=1;i<intervals.size();i++){
            Interval curr = intervals.get(i);
            Interval prev = intervals.get(i-1);
            if(curr.start<prev.end) return false;
        }
        return true;
    }
}
