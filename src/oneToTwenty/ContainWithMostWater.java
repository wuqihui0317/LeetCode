package oneToTwenty;
/**
 * @author wub
 * LeetCode
 * 11.Container With Most Water
 */
public class ContainWithMostWater {
    //暴力算法
    /*
    public int maxArea(int[] height){
        int x = 0;//当前横坐标
        int result = 0;
        for (int h : height){
            for (int i = x+1; i < height.length; i++) {
                int area = (i-x)*Math.min(h,height[i]);
                if (area > result)
                    result = area;
            }
            x++;
        }
        return result;
    }
    */

    //双指针法
    //思路：从两端开始，较长的边不动，较短的边往长边移动（只有这样才可能面积比上一个大）
    //     移动过程中用max记录最大值，return max
    public int maxArea(int[] height) {
        int head = 0;//head标记头指针
        int rear = height.length - 1;//rear标记尾指针
        int max = 0;
        int temp;
        while (head != rear) {
            if (height[head] > height[rear])
                temp = (rear - head) * height[rear--];
            else
                temp = (rear - head) * height[head++];
            max = max > temp ? max : temp;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainWithMostWater().maxArea(a));
    }
}
