/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int x = 0, y = 0;
        int dir = 0;
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        int current = 0;
        while (true) {
            if (x == n || x == -1 || y == n || y == -1)
                break;
            if (res[x][y] == 0)
                res[x][y] = ++current;
            else
                break;

            int xNext = x + dx[dir];
            int yNext = y + dy[dir];
            if (xNext == n || xNext == -1 || yNext == n || yNext == -1) {
                dir++;
                if (dir == 4)
                    dir = 0;
            } else if (res[xNext][yNext] != 0) {
                dir++;
                if (dir == 4)
                    dir = 0;
            }

            x += dx[dir];
            y += dy[dir];
        }
        return res;
    }
}
// @lc code=end
