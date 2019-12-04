package Twenty_OneToFourty;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wub
 * LeetCode
 * 35.Valid Sudoku
 * 9*9数独，每行每列不能重复，9个3*3不能重复
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set[] columns = new Set[9];//记录各列有无重复
        Set[] rows = new Set[9];//记录各行有无重复
        for (int i = 0; i < 9; i++) {
            columns[i] = new HashSet<Character>();
            rows[i] = new HashSet<Character>();
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set nums = new HashSet<>();//记录当前3*3数独有无重复
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        Object temp = board[i+k][j+l];
                        if (temp.equals('.'))    continue;
                        if (!(rows[i+k].add(temp) && columns[j+l].add(temp) && nums.add(temp)))    return false;
                    }
                }
            }
        }
        return true;
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
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }
}
