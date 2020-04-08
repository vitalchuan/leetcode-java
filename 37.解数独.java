import java.util.*;
/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    boolean[][] usedRow = new boolean[9][9];
    boolean[][] usedColumn = new boolean[9][9];
    boolean[][] usedBlock = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int row = 0; row < 9; row++)
            for (int column = 0; column < 9; column++) {
                if (board[row][column] != '.') {
                    char ch = board[row][column];
                    usedRow[row][ch - '0'-1] = true;
                    usedColumn[column][ch - '0'-1] = true;
                    usedBlock[row / 3 * 3 + column / 3][ch - '0'-1] = true;
                }
            }
        dfs(board, 0, 0);
    }

    public boolean dfs(char[][] board, int row, int column) {
        if (column == 9) {
            row++;
            column = 0;
            return dfs(board, row, column);
        }
        if (row == 9) {
            return true;
        }
        if (board[row][column] == '.') {
            for (char ch = '1'; ch <= '9'; ch++) {
                board[row][column] = ch;
                if (!usedRow[row][ch - '0'-1] && !usedColumn[column][ch - '0'-1]
                        && !usedBlock[row / 3 * 3 + column / 3][ch - '0'-1]) {
                    usedRow[row][ch - '0'-1] = true;
                    usedColumn[column][ch - '0'-1] = true;
                    usedBlock[row / 3 * 3 + column / 3][ch - '0'-1] = true;
                    if (dfs(board, row, column + 1))
                        return true;
                    usedRow[row][ch - '0'-1] = false;
                    usedColumn[column][ch - '0'-1] = false;
                    usedBlock[row / 3 * 3 + column / 3][ch - '0'-1] = false;
                }
                board[row][column] = '.';
            }
        } else if (Character.isDigit(board[row][column])) {
            return dfs(board, row, column + 1);
        }
        return false;
    }
}
// @lc code=end
