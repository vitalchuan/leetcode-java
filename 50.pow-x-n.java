/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (x == 1)
            return x;
        long v = n;
        boolean flag = true;
        if (v < 0) {
            flag = false;
            v = -v;
        }
        double res = 1;
        long count = 0;
        double a = x;
        while (count < v) {
            a = x;
            long i = 1;
            while ((count + 2 * i) <= v) {
                a = a * a;
                i = 2 * i;
            }
            res *= a;
            count += i;
        }
        return flag ? res : 1 / res;
    }
}
// @lc code=end
