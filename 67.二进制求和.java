/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        if (aLen < bLen)
            return addBinary(b, a);
            
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        
        int bit = 0;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < aLen; i++) {
            if (i >= bLen) {
                bit = carry + a.charAt(i) - '0';
            } else {
                bit = carry + a.charAt(i) - '0' + b.charAt(i) - '0';
            }
            switch (bit) {
                case 0:
                    carry = 0;
                    break;
                case 1:
                    carry = 0;
                    break;
                case 2:
                    bit = 0;
                    carry = 1;
                    break;
                case 3:
                    bit = 1;
                    carry = 1;
                    break;
            }
            res.append((char)(bit+'0'));
        }
        if(carry == 1)
            res.append((char)(1+'0'));
        return res.reverse().toString();
    }
}
// @lc code=end
