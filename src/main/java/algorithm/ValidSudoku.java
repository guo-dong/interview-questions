package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 有效的数独
 * https://leetcode.com/problems/valid-sudoku/description/
 * https://leetcode.com/problems/sudoku-solver/
 * @Author: guodong
 * @Date: 2018/12/19
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if(num != '.'){
                    if(!seen.add(num+"row"+i) || !seen.add(num+"col"+j) || !seen.add(num+"block"+i/3+"-"+j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9) return;
        solve2(board);

    }

    public boolean solve2(char[][] board){


        return true;
    }

    /**
     * 暴力法
     * @param board
     */
    public void solveSudokuByForce(char[][] board) {
        if (board == null || board.length != 9) return;
        solve(board);

    }
    public boolean solve(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.'){
                    for (char k = '1'; k <= '9'; k++) {
                        if(isValid(board,i,j,k)){//valid
                            board[i][j] = k;
                            if(solve(board)){
                                return true;
                            }else {
                                board[i][j] = '.';
                            }

                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char k) {
        for (int i = 0; i < 9; i++) {
            if(board[row][i]==k) return false;
            if(board[i][col]==k) return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3] == k) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
