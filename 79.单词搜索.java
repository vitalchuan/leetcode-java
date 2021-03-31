/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        List<Character> list = new LinkedList<>();
        boolean[][] mark = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    mark[i][j] = true;
                    if (dfs(1, word, mark, i, j, board))
                        return true;
                    mark[i][j] = false;
                }
            }
        }

        return false;
    }

    public boolean dfs(int currentLen, String word, boolean[][] mark, int x, int y, char[][] board) {
        if (currentLen == word.length()) {
            return true;
        }

        // 上下左右四个方向继续搜索
        if (x - 1 >= 0 && !mark[x - 1][y] && board[x - 1][y] == word.charAt(currentLen)) {
            mark[x - 1][y] = true;
            if (dfs(currentLen + 1, word, mark, x - 1, y, board))
                return true;
            mark[x - 1][y] = false;
        }

        if (x + 1 < board.length && !mark[x + 1][y] && board[x + 1][y] == word.charAt(currentLen)) {
            mark[x + 1][y] = true;
            if (dfs(currentLen + 1, word, mark, x + 1, y, board))
                return true;
            mark[x + 1][y] = false;
        }

        if (y - 1 >= 0 && !mark[x][y - 1] && board[x][y - 1] == word.charAt(currentLen)) {
            mark[x][y - 1] = true;
            if (dfs(currentLen + 1, word, mark, x, y - 1, board))
                return true;
            mark[x][y - 1] = false;
        }

        if (y + 1 < board[0].length && !mark[x][y + 1] && board[x][y + 1] == word.charAt(currentLen)) {
            mark[x][y + 1] = true;
            if (dfs(currentLen + 1, word, mark, x, y + 1, board))
                return true;
            mark[x][y + 1] = false;
        }
        return false;
    }
}
// @lc code=end
