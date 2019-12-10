package Forty_OneToSixty;

/**
 * @author wub
 * LeetCode
 * 52.N-Queens2
 * 将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击
 * 规则:同一行/列/对角线可以攻击
 * 得到解决n皇后问题的方法个数
 */
public class N_Queens2 {

    int count = 0;
    int[][] bound = null;//约束矩阵
    //我们发现，前一半和后一半的结果其实是相同的，我们只需要计算前一半可以怎么放置得到的个数即可
    public int totalNQueens(int n) {
        if (n <= 1) return 1;
        if (n <= 3)
           return 0;
        bound = new int[n][n];
        backtrack(0,n);
        return count;
    }
    void backtrack(int row,int n){
        for (int i = 0; i < n; i++) {
            if (bound[row][i] == 0) {
                if (row == n-1){
                    count++;return;
                }
                setBound(row, i, n, 1);
                backtrack(row+1,n);
                setBound(row,i,n,-1);
            }
        }
    }
    void setBound(int row,int column,int n,int way){
        int i = row+1;
        int j = column+1;
        //当前点右下方
        while (i < n && j < n) {
            bound[i][j] += way;
            i++;j++;
        }
        i = row-1;j = column-1;
        //当前点左上方
        while (i>=0 && j >= 0){
            bound[i][j] += way;
            i--;j--;
        }
        i = row+1;j = column-1;
        //当前点右上方
        while (i<n && j >= 0){
            bound[i][j] += way;
            i++;j--;
        }
        i = row-1;j = column+1;
        //当前点左下方
        while (i>=0 && j<n){
            bound[i][j] += way;
            i--;j++;
        }
        //当前点的上下
        i = row;j = column;
        for (int k = 0; k < n; k++) {
            bound[i][k] += way;
            bound[k][j] += way;
        }
    }

    public static void main(String[] args) {
        //System.out.println(new N_Queens2().solveNQueens(4));
    }
}
