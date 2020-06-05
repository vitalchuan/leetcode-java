/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len - 1] != 9) {
            digits[len - 1]++;
            return digits;
        } else {
            // 从后往前找到第一个不是9的元素索引
            int i = len - 1;
            while (digits[i] == 9) {
                i--;
                if (i == -1)
                    break;
            }
            if (i != -1) {
                digits[i]++;
                for (int j = i+1; j < len; j++)
                    digits[j] = 0;
                return digits;
            } else {
                // 全是9
                int[] res = new int[len + 1];
                res[0] = 1;
                return res;
            }
        }
    }
}
// @lc code=end
