package forty_OneToSixty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wub
 * LeetCode
 * 42.Trapping Rain Water
 * 给定一个数组代表高度，计算这个数组积水大小
 */
public class TrappingRainWater {
    //暴力思路：遍历数组，分别找出各个点积水高度（取两边最大值的较小值） O(N^2)
    //改进：遍历数组，分别用left[]/right[]记录左右两边到这个点之前的最大值，再遍历数组找各个点的积水高度 O(N)
    public int trap(int[] height) {
        int len = height.length;
        if(len < 3)   return 0;
        int sum = 0;
        int left_max = height[0];
        int right_max = height[len-1];
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 1; i < len-1; i++) {
            left[i] = left_max;
            if (height[i] > left_max)   left_max = height[i];
            right[len-1-i] = right_max;
            if (right_max < height[len-i-1])    right_max = height[len-1-i];
        }
        for (int i = 1; i < len-1; i++) {
            int temp = Math.min(left[i],right[i]) - height[i];
            if (temp > 0)   sum += temp;
        }


        return sum;
    }


    public static void main(String[] args) {
        int[] a = new int[]{4,2,0,3,2,5};
        System.out.println(new TrappingRainWater().trap(a));
    }
}
