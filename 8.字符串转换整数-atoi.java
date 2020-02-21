import com.oracle.webservices.internal.api.EnvelopeStyle;

/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        int sign = 1;
        long res = 0;
        str = str.trim();
        if(str.equals(""))
            return 0;
        if(str.charAt(0)=='-')
        {
            sign = -1;
            str = str.substring(1);
        }
        else if(str.charAt(0) == '+')
        {
            str = str.substring(1);
        }
        for (int i = 0; i < str.length(); i++)
            if (Character.isDigit(str.charAt(i))) {
                int a = str.charAt(i) - '0';
                res = 10 * res + a;
                if(res > Integer.MAX_VALUE)
                    break;
            } else
                break;
        res = sign * res;
        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int) res;
    }
}
// @lc code=end
