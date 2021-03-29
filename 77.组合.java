import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        dfs(resList, linkedList, n, k);
        return resList;
    }

    public void dfs(List<List<Integer>> resList, LinkedList<Integer> linkedList, int n, int k) {
        int listLen = linkedList.size();
        if (listLen == k)
            resList.add(linkedList);
        else {
            int lastE = linkedList.isEmpty() ? 0 : linkedList.getLast();
            if (lastE != n)
                for (int i = lastE + 1; i <= n; i++) {
                    linkedList.add(i);
                    dfs(resList, linkedList, n, k);
                    linkedList.removeLast();
                }
        }

    }
}
// @lc code=end
