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
                    int[] initPos = { i, j };
                    return dfs(1, word, mark, initPos);
                }

            }
        }
    }

    public boolean dfs(int currentLen, String word, booean[][] mark, int[] position) {
        if(currentLen == word.length()){
            return true;
        }
    }
}
// @lc code=end
