package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weasley on 2017-03-25.
 */
public class Q57_InsertIntervals {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("aa");
        list.add(null);
        System.out.println(list);
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans=new ArrayList<>();
        if(intervals.size()==0){
            ans.add(newInterval);
            return ans;
        }
        int i=0;
        //step1:找到插入的起始位置
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            ans.add(intervals.get(i));
            i++;
        }
        if (i < intervals.size()) {
            newInterval.start=Math.min(intervals.get(i).start,newInterval.start);
        }
        ans.add(newInterval);
        //step2:合并重叠的interval
        while (i<intervals.size()&&intervals.get(i).start<=newInterval.end){
            newInterval.end=Math.max(intervals.get(i).end,newInterval.end);
            i++;
        }
        //step3:加入剩余不重叠的interval
        while (i < intervals.size()) {
            ans.add(intervals.get(i));
            i++;
        }
        return ans;
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
