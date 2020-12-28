package forty_OneToSixty;

import java.util.Arrays;

/**
 * @author wub
 * LeetCode
 * 56.Merge Intervals
 * 合并间隔
 * int[n][2]代表n个间隔，合并这些间隔
 */
public class MergeIntervals {
    //先排序再合并
    public int[][] merge(int[][] intervals) {
        quickSort(intervals,0,intervals.length-1);
        if (intervals.length <= 1)  return intervals;
        int start = intervals[0][0];
        int end = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end){
                //merge当前和前一个
                start = start>intervals[i][0]?intervals[i][0]:start;
                end = end<intervals[i][1]?intervals[i][1]:end;
            }
            //不能合并则数组长度+1，更新start和end
            else {
                intervals[count][0] = start;
                intervals[count++][1] = end;
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        intervals[count][0] = start;
        intervals[count++][1] = end;
        return Arrays.copyOfRange(intervals,0,count);
    }
    void quickSort(int[][] a,int start,int end){
        int i = start;
        int j = end;
        if (i<j){
            int temp = a[i][0];
            int[] a0 = a[start];
            while (i<j){
                while (i<j && temp < a[j][0])    j--;
                if (i<j)    a[i++] = a[j];
                while(i<j && a[i][0] < temp)    i++;
                if (i<j)    a[j--] = a[i];
            }
            a[i] = a0;
            quickSort(a,start,i-1);
            quickSort(a,i+1,end);
        }
    }
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,3},{2,6},{8,10},{15,18}
        };
    }
}
