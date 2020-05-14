/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
import java.util.*;

class Solution {
    public int totalNQueens(int n) {
        int[] yUsedIndex = new int[n];
        for (int i = 0; i < n; i++)
            yUsedIndex[i] = -1;
        List<List<String>> res = new ArrayList<>();
        List<StringBuilder> current = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder a = new StringBuilder("");
            for (int j = 0; j < n; j++)
                a.append('.');
            current.add(a);
        }

        dfs(res, current, yUsedIndex, -1, n);

        return res.size();
    }

    public void dfs(List<List<String>> res, List<StringBuilder> current, int[] yUsedIndex, int xFin, int n) {
        if (xFin == n - 1) {
            List<String> list = new ArrayList<>();
            Iterator<StringBuilder> it = current.iterator();
            while (it.hasNext()) {
                list.add(it.next().toString());
            }
            res.add(list);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!validY(yUsedIndex, j, xFin))
                continue;
            else {
                current.get(xFin + 1).replace(j, j + 1, "Q");
                yUsedIndex[xFin + 1] = j;
                dfs(res, current, yUsedIndex, xFin + 1, n);
                yUsedIndex[xFin + 1] = -1;
                current.get(xFin + 1).replace(j, j + 1, ".");
            }
        }
    }

    public boolean validY(int[] yUsedIndex, int y, int xFin) {
        for (int i = 0; i <= xFin; i++) {
            if ((xFin + 1 - i) == Math.abs(yUsedIndex[i] - y))
                return false;
            if (yUsedIndex[i] == y)
                return false;
        }
        return true;
    }
}
// @lc code=end
