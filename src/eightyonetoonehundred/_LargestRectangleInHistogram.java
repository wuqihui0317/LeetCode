package eightyonetoonehundred;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author :wqh
 * @description :
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * @create :2020-12-17 10:50:00
 */
public class _LargestRectangleInHistogram {
    //dp 内存超限
    /**
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0){
            return 0;
        }
        int[][] dp = new int[heights.length][heights.length];
        int result = heights[0];
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                if (i == j){
                    dp[i][j] = heights[i];
                }else {
                    dp[i][j] = Math.min(heights[j], dp[i][j - 1]);
                }
                result = Math.max(result,dp[i][j]*(j-i+1));
            }
        }
        return result;
    }**/

    // stack,保证stack 1.栈顶元素都高度比栈内元素都要高
    // 如果碰到要入栈的高度低于栈顶，则开始出栈直到保持1，并计算出栈高度的面积最大值
    // 哨兵技巧：避免特殊情况的讨论（如链表虚拟头节点等）
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] heights2 = new int[heights.length+2];
        for (int i = 0; i < heights.length; i++) {
            heights2[i+1] = heights[i];
        }
        heights2[0] = 0;
        heights2[heights.length+1] = 0;
        stack.add(0);
        int area = 0;
        for (int i = 1; i < heights2.length; i++) {
            while (i < heights2.length && heights2[i] < heights2[stack.peekLast()]){
                int index = stack.pollLast();
                //heithts2[index] 高度； stack.peekLast -> 这个坐标之后的所有点 到i为止都不比index低
                area = Math.max(area, heights2[index] * (i-stack.peekLast()-1));
            }
            stack.add(i);
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(new _LargestRectangleInHistogram().largestRectangleArea(new int[]{1}));
    }
}
