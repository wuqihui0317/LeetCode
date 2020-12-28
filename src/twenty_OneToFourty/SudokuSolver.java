package twenty_OneToFourty;

/**
 * @author wub
 * LeetCode
 * 37.Sudoku Solver
 * 解9*9数独
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        //10为1~9 九个数字的状态
        boolean[][] rows = new boolean[9][10];
        boolean[][] columns = new boolean[9][10];
        boolean[][][] boxes = new boolean[3][3][10];
        //initiate
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j] - '0';
                if (board[i][j] != '.') {
                    rows[i][num] = true;
                    columns[j][num] = true;
                    boxes[i/3][j/3][num] = true;
                }
            }
        }
        backtrack(board,rows,columns,boxes,0,0);
    }
    public boolean backtrack(char[][] board,boolean[][] rows,boolean[][] columns,boolean[][][] boxes,int row,int column){
        if (column == 9){
            row++;
            column = 0;
            if (row == 9)  return true;
        }
        //看这个位置上是否需要填数
        if (board[row][column] == '.'){
            for (int i = 1; i < 10; i++) {
                boolean canUsed = !(rows[row][i] || columns[column][i] || boxes[row/3][column/3][i]);
                if (canUsed){
                    board[row][column] = (char)(i+'0');
                    rows[row][i] = true;
                    columns[column][i] = true;
                    boxes[row/3][column/3][i] = true;
                    if (backtrack(board,rows,columns,boxes,row,column+1))
                        return true;
                    else {
                        board[row][column] = '.';
                        rows[row][i] = false;
                        columns[column][i] = false;
                        boxes[row/3][column/3][i] = false;
                    }
                }
            }
        }
        else return backtrack(board,rows,columns,boxes,row,column+1);
        return false;
    }
    public static void main(String[] args) {
        String[] SS = new String[]{
                "5","3",".",".","7",".",".",".",".",
                "6",".",".","1","9","5",".",".",".",
                ".","9","8",".",".",".",".","6",".",
                "8",".",".",".","6",".",".",".","3",
                "4",".",".","8",".","3",".",".","1",
                "7",".",".",".","2",".",".",".","6",
                ".","6",".",".",".",".","2","8",".",
                ".",".",".","4","1","9",".",".","5",
                ".",".",".",".","8",".",".","7","9"
        };
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = SS[i*9+j].charAt(0);
            }
        }
        new SudokuSolver().solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
