package airbnb;

import airbnb.struct.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tyh on 2017/9/3.
 */
public class MergeIntervals {
    /**
     * N个员工，每个员工有若干个interval表示在这段时间是忙碌的。求所有员工都不忙的intervals
     * 解法：这题最简单的方法就是把所有区间都拆成两个点，然后排序，然后扫描，每次碰到一个点如果是左端点就把busy_employees加1，
     * 否则减1，等到每次busy_employees为0时就是一个新的区间。这样复杂度O(MlogM)，M是总共区间数。
     */
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(2, 6));
        input.add(new Interval(8, 10));
        input.add(new Interval(15, 18));
        List<Interval> output = merge(input);
        for(Interval interval : output){
            System.out.println(interval.toString());
        }
    }
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0){
            return res;
        }
        //new comparator to sort the intervals list by start time
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(cur.start <= end){
                end = cur.end > end ? cur.end : end;
            }
            else{
                //got a new interval
                Interval newItem = new Interval(start, end);
                res.add(newItem);
                start = cur.start;
                end = cur.end;
            }
        }
        Interval newItem = new Interval(start, end);
        res.add(newItem);
        return res;
    }
}
