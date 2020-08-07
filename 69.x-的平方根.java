/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        long left = 0, right = x;
        long mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (mid * mid > x)
                right = mid;
            else if (mid * mid < x) {
                if ((mid + 1) * (mid + 1) > x)
                    return (int)mid;
                left = mid + 1;
            } else if (mid * mid == x)
                return (int)mid;
        }
        return (int)left;
    }
}
// @lc code=end
