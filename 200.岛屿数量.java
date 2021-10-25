import java.util.Map;

import org.graalvm.compiler.core.common.alloc.UniDirectionalTraceBuilder;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    // 1 dfs
    // private boolean[][] visited;
    // private int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
    // private int rows;
    // private int cols;
    // private char[][] grid;

    // public int numIslands(char[][] grid) {
    // rows = grid.length;
    // cols = grid[0].length;
    // this.grid = grid;

    // int counts = 0;
    // visited = new boolean[rows][cols];

    // for (int i = 0; i < rows; i++) {
    // for (int j = 0; j < cols; j++) {
    // if (grid[i][j] == '1' && visited[i][j] == false) {
    // counts++;
    // dfs(i, j);
    // }
    // }
    // }
    // return counts;
    // }

    // public void dfs(int i, int j) {
    // visited[i][j] = true;
    // for (int a = 0; a < 4; a++) {
    // int m = i + directions[a][0];
    // int n = j + directions[a][1];
    // if (m >= 0 && m < rows && n >= 0 && n < cols && visited[m][n] == false &&
    // grid[m][n] == '1')
    // dfs(m, n);
    // }
    // }

    // 并查集
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = { { 1, 0 }, { 0, 1 } };
        int spaces = 0; // 湖泊的个数
        UnionFind unionFind = new UnionFind(rows * cols);

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j;
                unionFind.add(index);
                if (grid[i][j] == '0')
                    spaces++;
            }

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == '1') {
                    // 尝试对右方和下方为陆地的区域合并
                    for (int m = 0; m <= 1; m++) {
                        int nextI = i + directions[m][0];
                        int nextJ = j + directions[m][1];
                        if (nextI >= 0 && nextI < rows && nextJ >= 0 && nextJ < cols && grid[nextI][nextJ] == '1') {
                            unionFind.union(i * cols + j, nextI * cols + nextJ);
                        }
                    }
                }

        return unionFind.counts - spaces;
    }

    static class UnionFind {
        public Map<Integer, Integer> map = new HashMap<>();
        public int counts = 0;

        public void add(int n) {
            map.put(n, n);
        }

        public UnionFind(int n) {
            counts = n;
        }

        public int find(int n) {
            while (map.get(n) != n) {
                n = map.get(n);
            }
            return n;
        }

        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);

            if (aRoot == bRoot)
                return;

            counts--;
            map.put(aRoot, bRoot);
        }
    }

}
// @lc code=end
