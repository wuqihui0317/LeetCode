package sixty_OneToEighty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wqh
 * @description :
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @create :2020-12-15 10:10:00
 */
public class WordSearch {
    //回溯
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0){
            return true;
        }else if (board.length == 0 || board[0].length == 0){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    board[i][j] = '0';
                    if (backtrack(board,i,j,word,1)){
                        return true;
                    }
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }
    boolean backtrack(char[][] board, int i, int j, String word, int wordstart){
        if (word.length() == wordstart){
            return true;
        }
        //上下左右
        if (i > 0 && board[i-1][j] == word.charAt(wordstart)){
            board[i-1][j] = '0';
            if (backtrack(board,i-1,j,word,wordstart+1)){
                return true;
            }
            board[i-1][j] = word.charAt(wordstart);
        }
        if (j > 0 && board[i][j-1] == word.charAt(wordstart)){
            board[i][j-1] = '0';
            if (backtrack(board,i,j-1,word,wordstart+1)){
                return true;
            }
            board[i][j-1] = word.charAt(wordstart);
        }
        if (i < board.length-1 && board[i+1][j] == word.charAt(wordstart)){
            board[i+1][j] = '0';
            if (backtrack(board,i+1,j,word,wordstart+1)){
                return true;
            }
            board[i+1][j] = word.charAt(wordstart);
        }
        if (j < board[0].length-1 && board[i][j+1] == word.charAt(wordstart)){
            board[i][j+1] = '0';
            if (backtrack(board,i,j+1,word,wordstart+1)){
                return true;
            }
            board[i][j+1] = word.charAt(wordstart);
        }
        return false;
    }
}
