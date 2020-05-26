
/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 */
import java.util.*;

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);

        while (true) {
            int index = (k - 1) / factorial(list.size() - 1);
            sb.append(list.get(index));

            k = k - index * factorial(list.size() - 1);
            list.remove(index);
            if (list.isEmpty())
                break;
        }
        return sb.toString();
    }

    public int factorial(int n) {
        int res = 1;
        while (n != 0) {
            res *= n--;
        }
        return res;
    }

}
// @lc code=end
