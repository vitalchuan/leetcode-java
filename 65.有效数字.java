/*
 * @lc app=leetcode.cn id=65 lang=java
 *
 * [65] 有效数字
 */

// @lc code=start
class Solution {
    public boolean isNumber(String s) {
        char[] charArrayOfs = s.trim().toCharArray();
        boolean numSeen = false, dotSeen = false, eSeen = false;

        for (int i = 0; i < charArrayOfs.length; i++) {
            if (charArrayOfs[i] >= '0' && charArrayOfs[i] <= '9') {
                numSeen = true;
            } else if (charArrayOfs[i] == '.') {
                if (dotSeen || eSeen)
                    return false;
                dotSeen = true;
                // if (!numSeen)
                // return false;
            } else if (charArrayOfs[i] == 'e' || charArrayOfs[i] == 'E') {
                if (!numSeen)
                    return false;
                if (eSeen)
                    return false;// e1234e23
                eSeen = true;
                numSeen = false;
            } else if (charArrayOfs[i] == '+' || charArrayOfs[i] == '-') {
                if (i != 0) {
                    if (eSeen) {
                        if (charArrayOfs[i - 1] != 'e' && charArrayOfs[i - 1] != 'E')
                            return false;
                    } else {
                        if (i != 0)
                            return false;
                    }
                }
            } else
                return false;
        }
        return numSeen;
    }
}
// @lc code=end
