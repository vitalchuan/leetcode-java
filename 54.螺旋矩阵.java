import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        int x = 0, y = 0;
        int m = matrix.length;
        if (m == 0)
            return list;
        int n = matrix[0].length;
        int[][] visited = new int[m][n];
        int di = 0;
        /**
         * 0 i+1 1 j+1 2 i-1 3 j-1
         */
        int[] dx = { 0, -1, 0, 1 };
        int[] dy = { 1, 0, -1, 0 };
        while (true) {
            if (x < 0 || x >= m || y < 0 || y >= n)
                return list;
            if (visited[x][y] == 0) {
                visited[x][y] = 1;
                list.add(matrix[x][y]);
            }
            else return list;

            int xNext = x + dx[di];
            int yNext = y + dy[di];
            if (xNext >= m || xNext < 0 || yNext >= n || yNext < 0) {
                di--;
                if (di == -1)
                    di = 3;
                xNext = x + dx[di];
                yNext = y + dy[di];
            } else if (visited[xNext][yNext] == 1) {
                di--;
                if (di == -1)
                    di = 3;
                int x1 = x + dx[di];
                int y1 = y + dy[di];
                if (visited[x1][y1] == 1)
                    return list;
                else {
                    xNext = x1;
                    yNext = y1;
                }
            }
            x = xNext;
            y = yNext;
        }
    }
}
// @lc code=end
