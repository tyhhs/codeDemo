package interview.airbnb;

import interview.airbnb.struct.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by tyh on 2017/9/3.
 */
public class MeetingRooms {

    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
     * determine if a person could attend all meetings.
     * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
     * @param args
     */
    public static void main(String[] args) {
        Interval[] input = new Interval[3];
        input[0] = new Interval(0, 30);
        input[1] = new Interval(5, 10);
        input[2] = new Interval(15, 20);
        System.out.println(canAttendMeetings(input));
    }
    public static boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return true;
        }
        //sort array by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int end = intervals[0].end;
        for(int i = 1; i < intervals.length; i++){
            Interval cur = intervals[i];
            if(cur.start < end){
                return false;
            }
            end = cur.end;
        }
        return true;
    }
}
