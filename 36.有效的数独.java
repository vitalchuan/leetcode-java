import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (!isValidSudokuColumn(board))
            return false;
        if (!isValidSudokuRow(board))
            return false;
        if (!isValidSudokuBlock(board))
            return false;
        return true;
    }

    /**
     * 检测行是否有效
     * 
     * @param board
     * @return
     */
    public boolean isValidSudokuRow(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j]))
                    if (set.contains(board[i][j]))
                        return false;
                    else
                        set.add(board[i][j]);
            }
        }
        return true;
    }

    /**
     * 检测列是否有效
     * 
     * @param board
     * @return
     */
    public boolean isValidSudokuColumn(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[j][i]))
                    if (set.contains(board[j][i]))
                        return false;
                    else
                        set.add(board[j][i]);
            }
        }
        return true;
    }

    public boolean isValidSudokuBlock(char[][] board) {
        for (int i = 0; i < 9; i += 3)
            for (int j = 0; j < 9; j += 3) {
                Set<Character> set = new HashSet<>();
                for (int m = 0; m < 3; m++)
                    for (int n = 0; n < 3; n++)
                        if (Character.isDigit(board[i + m][j + n]))
                            if (set.contains(board[i + m][j + n]))
                                return false;
                            else
                                set.add(board[i + m][j + n]);
            }
        return true;
    }
}
// @lc code=end
