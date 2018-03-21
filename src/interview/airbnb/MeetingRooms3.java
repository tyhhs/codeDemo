package interview.airbnb;

import interview.airbnb.struct.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by tyh on 2017/9/12.
 */
public class MeetingRooms3 {
    // 给一组meetings（每个meeting由start和end时间组成）。求出在所有输入meeting时间段内没有会议，
    // 也就是空闲的时间段。每个subarray都已经sort好。N个员工，每个员工有若干个interval表示在这段时间是忙碌的。
    // 求所有员工都不忙的intervals

    public static void main(String[] args) {
        List<List<Interval>> time = new ArrayList<>();
        time.add(new ArrayList<>(Arrays.asList(new Interval(1, 3),new Interval(6, 7))));
        time.add(new ArrayList<>(Arrays.asList(new Interval(2, 4))));
        time.add(new ArrayList<>(Arrays.asList(new Interval(2, 3),new Interval(9, 12))));
        System.out.println(findIntervals(time));
    }

    public static int findIntervals(List<List<Interval>> time){
        int count = 0;
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for(List<Interval> personSchedule : time){
            for(Interval person : personSchedule){
                start.add(person.start);
                end.add(person.end);
            }
        }
        Collections.sort(start);
        Collections.sort(end);
        int busy = 0;
        int i = 0;
        int j = 0;
        while(i < start.size() && j < end.size()){
            int temp;
            if(start.get(i) <= end.get(j)){
                temp = start.get(i);
                i++;
                busy++;
            }else{
                temp = end.get(j);
                j++;
                busy--;
            }
            if(busy == 0){
                count++;
            }
        }
        return count;
    }
}
