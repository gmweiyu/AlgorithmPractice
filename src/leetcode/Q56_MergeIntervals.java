package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Weasley on 2017-03-22.
 */
public class Q56_MergeIntervals {
    public static void main(String[] args) {

    }

    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals==null||intervals.isEmpty()) return intervals;
        List<Interval> ans=new ArrayList<>();
        //首先对intervals排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start==o2.start)  return o1.end-o2.end;
                return o1.start-o2.start;
            }
        });
        ans.add(intervals.get(0));      //先添加第一个
        //依次添加interval
        for(int i=1;i<intervals.size();i++){
            //待添加的interval、ans中的最后一个interval
            Interval newInter=intervals.get(i),ansLast=ans.get(ans.size()-1);
            //只需要比较ans中最后一个元素的end和新加元素的start,因为start已经有序
            if (ansLast.end >= newInter.start) {
                ansLast.end = Math.max(ansLast.end, newInter.end);
            } else {
                ans.add(newInter);
            }
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
