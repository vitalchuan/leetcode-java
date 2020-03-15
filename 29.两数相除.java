/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start

class Solution {
    public int divide(int dividend, int divisor) {
        // boolean zf = true;
        // boolean buwei = false;
        // int result = 0;
        // if(divisor == 1) return dividend;
        // if(divisor == -1){
        // if(dividend == Integer.MIN_VALUE)
        // return 0-(dividend+1);
        // else
        // return 0-dividend;
        // }
        // //被除数有溢出可能
        // if (dividend < 0) {
        // if(dividend == Integer.MIN_VALUE){
        // dividend = 0 - (dividend + 1);
        // buwei = true;
        // }
        // else dividend = 0 - dividend;
        // zf = !zf;
        // }

        // //除数有溢出可能
        // if(divisor == Integer.MIN_VALUE)
        // return dividend == Integer.MIN_VALUE ? 1 : 0;

        // if (divisor < 0) {
        // divisor = 0 - divisor;
        // zf = !zf;
        // }
        // while (dividend >= divisor) {
        // dividend -= divisor;
        // if(buwei) {
        // dividend += 1;
        // buwei = false;
        // }
        // result += 1;
        // }
        // return zf ? result : (0 - result);

        boolean sign = true;
        int result = 0;
        if (dividend < 0)
            sign = !sign;
        if (divisor < 0)
            sign = !sign;
        if (dividend > 0)
            dividend = 0 - dividend;
        if (divisor > 0)
            divisor = 0 - divisor;
        while (dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            /**
             * 左移一位 等价于 乘以2（规避无法使用的规定，能够改善时间性能） 
             * 该while写法最好，在比较时，将dividend与temp_divisor的两倍相比
             * 注：当temp_divisor<<1可能会溢出，因此需要直接赋值给temp_divisor
             */
            // while (dividend <= (temp_divisor = (temp_divisor << 1))) {
            while (dividend <= (temp_divisor << 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE) >> 1)   
                    break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if (sign) {
            if (result == Integer.MIN_VALUE)
                return 0 - (result + 1);
            else
                return 0 - result;
        }
        else{
            return result;
        }

    }
}
// @lc code=end
