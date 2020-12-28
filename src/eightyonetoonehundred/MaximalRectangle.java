package eightyonetoonehundred;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author :wqh
 * @description :
 * 85. 最大矩形
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * @create :2020-12-21 17:27:00
 */
public class MaximalRectangle {
    //暴力解法：遍历所有点，找出以此点为右下角的所有矩形并比较大小
    //找矩形的方法：改数组为在这行上连续1的个数，并计算这个点为右下角点点矩阵最大面积
    /*
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != '0'){
                    if (j != 0 && matrix[i][j-1] != '0') {
                        matrix[i][j] = (char) (matrix[i][j - 1] + 1);
                    }
                    int width = matrix[i][j] - '0';
                    for (int k = i; k >= 0; k--) {
                        if (matrix[k][j] != '0'){
                            //能取到的最大宽
                            width = Math.min(matrix[k][j] - '0', width);
                            result = Math.max(result,width * (i-k+1));
                        }else {
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
*/
    @SuppressWarnings("")
    /**
     * 10100
     * 10111
     * 11111
     * 10010
     * 相当于以各行 为 边界分别计算 84.柱状图中的最大矩形 取最大值
     */
    public int maximalRectangle(char[][] matrix) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.add(-1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int height = 0;
                if (matrix[i][j] != '0') {
                    height = matrix[i][j] - '0' + (i > 0 ? matrix[i - 1][j] - '0' : 0);
                    matrix[i][j] = (char)('0' + height);
                }
                while (stack.peekLast() != -1 && height < (matrix[i][stack.peekLast()] - '0')){
                    int index = stack.pollLast();
//                    if (stack.peekLast() == -1){
//                        result = Math.max(result , (j - index) * (matrix[i][index] - '0'));
//                    }else {
//                        result = Math.max(result, (j - stack.peekLast() - 1) * (matrix[i][index] - '0'));
//                    }
                    result = Math.max(result, (j - stack.peekLast() - 1) * (matrix[i][index] - '0'));
                }
                stack.add(j);
                if (j == matrix[i].length-1){
                    j++;
                    while (stack.size() != 1){
                        int index = stack.pollLast();
//                        if (stack.peekLast() == -1){
//                            result = Math.max(result, (j - index) * (matrix[i][index] - '0'));
//                        }else {
//                            result = Math.max(result, (j - stack.peekLast() - 1) * (matrix[i][index] - '0'));
//                        }
                        result = Math.max(result, (j - stack.peekLast() - 1) * (matrix[i][index] - '0'));
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] chars = new char[5][5];
        chars[0] = "10001".toCharArray();
        chars[1] = "11011".toCharArray();
        chars[2] = "11111".toCharArray();
        chars[3] = "00000".toCharArray();
        chars[4] = "00000".toCharArray();
        System.out.println(new MaximalRectangle().maximalRectangle(chars));
    }
}
