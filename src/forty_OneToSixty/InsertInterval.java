package forty_OneToSixty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wub
 * LeetCode
 * 57.Insert Interval
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null)    return intervals;
        if (intervals.length == 0)
            return new int[][]{{newInterval[0],newInterval[1]}};
        List<int[]> result = new ArrayList<>();
        int i;//记录intervals数组遍历到哪个位置了（还未插入result中的下标）
        for (i = 0; i < intervals.length; i++) {
            if (newInterval[0] < intervals[i][0]){
                if (i == 0) result.add(newInterval);
                else {
                    //merge newInterval和result的最后一个数组
                    int end = result.get(i-1)[1];
                    if (result.get(i-1)[1] >= newInterval[0])
                        result.get(i-1)[1] = newInterval[1] > end ? newInterval[1] : end;
                    else result.add(newInterval);
                }
                break;
            }
            else result.add(intervals[i]);
        }
        int size = result.size();//记录result大小
        int end = result.get(size-1)[1];
        //intervals遍历完了还没有插进去
        if (i == intervals.length){
            if (intervals[i-1][1] >= newInterval[0]) {
                intervals[i - 1][1] = end > newInterval[1] ? end : newInterval[1];
                return intervals;
            }
            else result.add(newInterval);
        }
        for (;i < intervals.length; i++) {
            if (end < intervals[i][0])
                break;
            else {
                result.get(size-1)[1] = end<intervals[i][1]?intervals[i][1]:end;
            }
        }
        for (; i < intervals.length; i++) {
            result.add(intervals[i]);
        }
        return result.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,5}
        };
        new InsertInterval().insert(a,new int[]{2,7});
    }
}
