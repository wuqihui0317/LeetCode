package Sixty_OneToEighty;
/**
 * @author wub
 * LeetCode
 * 64.Minimum Path Sum
 * 找出从非负矩阵左上方到右下方路径上的数字和最小的路径，返回这个和
 */
public class MinimumPathSum {
    //动态规划
    //第一行第一列只能从起点右走和下走，初始化时先更新这些点
    //从1，1 开始遍历数组，找出从起点到该点最短的路径长度，并在grid上更新
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        if (row == 0 || column == 0)   return 0;
        //初始化
        for (int i = 1; i < column; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i-1][0];
        }
        //动态规划
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] += (grid[i-1][j] > grid[i][j-1]?grid[i][j-1]:grid[i-1][j]);
            }
        }
        return grid[row-1][column-1];
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,2,5},
                {3,2,1}
        };
        new MinimumPathSum().minPathSum(a);
    }
}
