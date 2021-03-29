import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> current = new LinkedList<>();
        dfs(res, current, nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, LinkedList<Integer> currentIndex, int[] nums) {
        res.add(indexToList(currentIndex, nums));
        int last = currentIndex.isEmpty() ? -1 : currentIndex.getLast();
        for (int i = last + 1; i < nums.length; i++) {
            currentIndex.add(i);
            dfs(res,currentIndex,nums);
            currentIndex.removeLast();
        }
    }

    public List<Integer> indexToList(List<Integer> index, int[] nums) {
        Iterator<Integer> it = index.iterator();
        List<Integer> res = new LinkedList<>();
        while (it.hasNext()) {
            res.add(nums[it.next()]);
        }
        return res;
    }
}

// @lc code=end
