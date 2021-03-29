import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> current = new LinkedList<>();

        
    }

    public void dfs(List<List<Integer>> res, LinkedList<Integer> current, int n, int k) {
        int len = current.size();
        if (len == k) {
            res.add(current);
            return;
        }

        int last = current.isEmpty() ? 0 : current.getLast();
        for (int i = last + 1; i <= n; i++) {
            current.add(i);
            dfs(res,current,n,k);
            current.removeLast();
        }
    }

}
// @lc code=end
