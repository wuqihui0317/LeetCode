package Forty_OneToSixty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wub
 * LeetCode
 * 54.Spiral Matrix
 * 顺时针螺旋遍历数组
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return result;
        int startRow = 0;
        int startColumn = 0;
        int endRow = matrix.length - 1;
        int endColumn = matrix[0].length - 1;
        while (endRow > startRow && endColumn > startColumn){
            //上边
            for (int i = startColumn; i <= endColumn; i++) {
                result.add(matrix[startRow][i]);
            }
            //右边
            for (int i = startRow+1; i <= endRow; i++) {
                result.add(matrix[i][endColumn]);
            }
            //下边
            for (int i = endColumn-1; i >= startColumn; i--) {
                result.add(matrix[endRow][i]);
            }
            //左边
            for (int i = endRow-1; i > startRow ; i--) {
                result.add(matrix[i][startColumn]);
            }
            startRow++;startColumn++;endRow--;endColumn--;
        }
        if (endRow == startRow){
            for (int i = startColumn; i <= endColumn ; i++) {
                result.add(matrix[startRow][i]);
            }
        }
        else if (endColumn == startColumn){
            for (int i = startRow; i <= endRow ; i++) {
                result.add(matrix[i][startColumn]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(new SpiralMatrix().spiralOrder(a));
    }
}
