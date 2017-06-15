/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start; //根据Interval的start排序
            }
        });

        List<Interval> ret = new ArrayList<>();
        Interval prev = null;
        for (Interval inter : intervals) {
            if (  prev==null || inter.start>prev.end ) { //如果prev为空或者前一个Interval的end大于现在操作的Interval的start，则现在操作的Interval可以直接添加入结果链表
                ret.add(inter);
                prev = inter; //保存新添加的Interval到prev，用于下一次的比较
            } else if (inter.end>prev.end) {  //如果当前的Interval的end大于前一个Interval的end
                prev.end = inter.end;//则将前一个添加的Interval的end赋值为当前操作的Interval，当前的Interval就操作完毕，进入下一个Interval
            }
        }
        return ret;
    }
}