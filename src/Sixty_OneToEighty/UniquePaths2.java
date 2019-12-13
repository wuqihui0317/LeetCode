package Sixty_OneToEighty;

import java.util.Arrays;

/**
 * @author wub
 * LeetCode
 * 63.Unique Paths2
 * 在62的基础上多了障碍物，有障碍物的点不能移动
 */
public class UniquePaths2 {
    //递归，会超时
    /*
    int[][] obstacle = null;
    int endRow;
    int endColumn;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length < 1 && obstacleGrid[0].length < 1)
            return 0;
        obstacle = obstacleGrid;
        endRow = obstacleGrid.length-1;
        endColumn = obstacleGrid[0].length-1;
        return backtrack(0,0);
    }
    int backtrack(int nowRow,int nowColumn){
        if (obstacle[nowRow][nowColumn] == 1)
            return 0;
        if (nowRow == endRow){
            for (int i = nowColumn+1; i <= endColumn; i++) {
                if (obstacle[nowRow][i] == 1)
                    return 0;
            }
            return 1;
        }
        if (nowColumn == endColumn){
            for (int i = nowRow+1; i <= endRow; i++) {
                if (obstacle[i][nowColumn] == 1)
                    return 0;
            }
            return 1;
        }
        return backtrack(nowRow+1,nowColumn) + backtrack(nowRow,nowColumn+1);
    }
    */
    //动态规划
    //直接在obstacleGrid数组中动态规划（到当前点的路径数量）
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length < 1 || obstacleGrid[0].length < 1)
            return 0;
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row-1][column-1] == 1)
            return 0;

        //初始化数组的第一行和第一列
        for (int k = 0; k < column; k++) {
            if (obstacleGrid[0][k] == 1){
                for (;k < column; k++)
                    obstacleGrid[0][k] = 0;
            }
            else obstacleGrid[0][k] = 1;
        }
        for (int k = 1; k < row; k++) {
            if (obstacleGrid[k][0] == 1){
                for (;k < row; k++)
                    obstacleGrid[k][0] = 0;
            }
            else obstacleGrid[k][0] = 1;
        }
        if (row == 1 || column == 1)
            return obstacleGrid[row-1][column-1];
        for (int j = 1; j < column; j++) {
            for (int i = 1; i < row; i++) {
                if (obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[row-1][column-1];
    }
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {0,0},
                {1,0},
                {0,0},
                {0,1},
                {0,0}
        };
        new UniquePaths2().uniquePathsWithObstacles(a);
    }
}
