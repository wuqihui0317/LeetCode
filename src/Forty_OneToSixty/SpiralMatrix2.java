package Forty_OneToSixty;

/**
 * @author wub
 * LeetCode
 * 59.Spiral Matrix2
 * 给定一个正整数n，返回一个n*n螺旋矩阵（1 - n^2）
 */
public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int top = 0;//上边的row
        int bottom = n-1;//底边的row
        int left = 0;//左边的column
        int right = n-1;//右边的column
        int num = 1;//要放入result的值
        while(top < bottom){
            //上边
            for (int i = left; i < right; i++) {
                result[top][i] = num++;
            }
            //右边
            for (int i = top; i < bottom; i++) {
                result[i][right] = num++;
            }
            //底边
            for (int i = right; i > left; i--) {
                result[bottom][i] = num++;
            }
            //左边
            for (int i = bottom; i > top; i--) {
                result[i][left] = num++;
            }
            top++;right--;bottom--;left++;
        }
        if (top == bottom)
            result[top][left] = num;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrix2().generateMatrix(3));
    }
}
