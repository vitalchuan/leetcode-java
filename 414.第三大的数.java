import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int i : nums) {
            set.add(i);
            if (set.size() > 3)
                set.remove(set.first());
        }

        if (set.size() < 3)
            return set.last();
        else
            return set.first();

    }
}
// @lc code=end
