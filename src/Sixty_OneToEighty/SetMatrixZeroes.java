package Sixty_OneToEighty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wub
 * LeetCode
 * 73.Set Matrix Zeroes
 *
 * 如果数组中有0 则设置这行这列的元素都是0
 * 要求原地算法
 */
public class SetMatrixZeroes {
    Set<Integer> columnSet = new HashSet<>();
    Set<Integer> rowSet = new HashSet<>();
    //使用两个Set记录已经被设置的行列
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        for (int i = 0; i < matrix.length; i++) {
            //i列已经遍历过了
            if (rowSet.contains(i))
                continue;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    if (!rowSet.contains(i) && !columnSet.contains(j)) {
                        setRowZeroes(matrix,i);
                        break;
                    }
                }
            }
        }
    }

    void setRowZeroes(int[][] matrix,int row){
        rowSet.add(row);
        for (int i = 0; i < matrix[row].length; i++) {
            if (matrix[row][i] == 0 && !columnSet.contains(i))
                setColumnZeroes(matrix,i);
            else matrix[row][i] = 0;
        }
    }
    void setColumnZeroes(int[][] matrix,int column){
        columnSet.add(column);
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][column] == 0 && !rowSet.contains(i))
                setRowZeroes(matrix,i);
            else matrix[i][column] = 0;
        }
    }
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,1,1},
            {1,0,1},
                {1,1,1}
        };
        new SetMatrixZeroes().setZeroes(a);
        System.out.println(Arrays.deepToString(a));
    }
}
