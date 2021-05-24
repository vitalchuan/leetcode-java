import jdk.internal.jshell.tool.resources.l10n;

/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    public int m, n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        boolean[][] marked = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(board, marked, i, 0);
            dfs(board, marked, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(board, marked, 0, j);
            dfs(board, marked, m - 1, j);
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == 'O' && marked[i][j] == false)
                    board[i][j] = 'X';

    }

    // 标记与边缘O 相连的O
    public void dfs(char[][] board, boolean[][] marked, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || marked[i][j] == true)
            return;

        if (board[i][j] == 'O') {
            marked[i][j] = true;
            dfs(board, marked, i + 1, j);
            dfs(board, marked, i - 1, j);
            dfs(board, marked, i, j + 1);
            dfs(board, marked, i, j - 1);
        }
    }

}
// @lc code=end
