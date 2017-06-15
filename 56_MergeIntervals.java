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
                return obj0.start - obj1.start; //����Interval��start����
            }
        });

        List<Interval> ret = new ArrayList<>();
        Interval prev = null;
        for (Interval inter : intervals) {
            if (  prev==null || inter.start>prev.end ) { //���prevΪ�ջ���ǰһ��Interval��end�������ڲ�����Interval��start�������ڲ�����Interval����ֱ�������������
                ret.add(inter);
                prev = inter; //��������ӵ�Interval��prev��������һ�εıȽ�
            } else if (inter.end>prev.end) {  //�����ǰ��Interval��end����ǰһ��Interval��end
                prev.end = inter.end;//��ǰһ����ӵ�Interval��end��ֵΪ��ǰ������Interval����ǰ��Interval�Ͳ�����ϣ�������һ��Interval
            }
        }
        return ret;
    }
}