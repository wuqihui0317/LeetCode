package forty_OneToSixty;

import java.util.Arrays;

/**
 * @author wub
 * LeetCode
 * 48.Rotate Image
 * 有一个n*n数组，求其顺时针旋转90度之后的数组
 * 要求直接在当前数组上操作
 */
public class RotateImage {
    //思路：从最外圈开始缩圈
    // 然后分别从四条边第一个数出发（顺时针看），遍历到第n-1个，顺时针交换他们
    public void rotate(int[][] matrix) {
        if (matrix.length < 1)  return;
        int n = matrix[0].length;
        int t = 0;//上面边的横坐标
        int r = n-1;//右边的边的纵坐标
        int b = n-1;//底边的横坐标
        int l = 0;//左边的边的纵坐标
        for (int i = n; i >= 2 ; i = i - 2) {
            for (int j = 0; j < i-1; j++) {
                //顺时针交换四个数
                int temp = matrix[t][j+t];
                matrix[t][j+t] = matrix[b-j][l];
                matrix[b-j][l] = matrix[b][r-j];
                matrix[b][r-j] = matrix[j+t][r];
                matrix[j+t][r] = temp;
            }
            t++;r--;b--;l++;
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[4][4];
        int n = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                a[i][j] = n++;
            }
        }
        new RotateImage().rotate(a);
        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));
        System.out.println(Arrays.toString(a[2]));
        System.out.println(Arrays.toString(a[3]));

    }
}
