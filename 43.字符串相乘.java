/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        StringBuilder prev = new StringBuilder();
        StringBuilder current = new StringBuilder();
        for (int j = 0; j < num2.length(); j++) {
            int bit = 0;
            int carry = 0;
            for (int i = 0; i < num1.length(); i++) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                bit = (a * b + carry) % 10;
                carry = (a * b + carry) / 10;
                current.append((char) (bit + '0'));
            }
            if (carry != 0)
                current.append((char) (carry + '0'));
            current.reverse();
            for (int i = 0; i < j; i++)
                current.append('0');
            current.reverse();
            prev = add(current, prev);
            current = new StringBuilder();
        }

        return prev.reverse().toString();
    }

    public StringBuilder add(StringBuilder num1, StringBuilder num2) {
        StringBuilder res = new StringBuilder();

        int i = 0;
        int j = 0;
        int carry = 0;
        while (i < num1.length() || j < num2.length() || carry != 0) {
            int a = (i < num1.length()) ? (num1.charAt(i) - '0') : 0;
            int b = (j < num2.length()) ? (num2.charAt(j) - '0') : 0;
            int bit = (a + b + carry) % 10;
            res.append((char) (bit + '0'));
            carry = (a + b + carry) / 10;
            i++;
            j++;
        }
        return res;
    }
}
// @lc code=end
