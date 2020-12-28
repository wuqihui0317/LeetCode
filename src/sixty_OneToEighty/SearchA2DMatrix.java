package sixty_OneToEighty;

/**
 * @author wub
 * LeetCode
 * 74.Search a 2D Matrix
 * 判断矩阵matrix中是否有target
 * matrix是一个行升序排列的矩阵，下一行第一个数大于上一行最后一个
 */
public class SearchA2DMatrix {
    //思路：先找到所在的行，再用二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = 0;
        for (; row < matrix.length && matrix[row][0] <= target; row++);
        if (row == 0)
            return false;
        row--;
        int start = 0;
        int end = matrix[row].length - 1;
        while (start <= end){
            int mid = (start + end)/2;
            if (matrix[row][mid] > target)
                end = mid - 1;
            else if (matrix[row][mid] < target)
                start = mid + 1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1}};
        System.out.println(new SearchA2DMatrix().searchMatrix(a,1));
    }
}
