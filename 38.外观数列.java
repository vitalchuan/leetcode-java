/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder();
        int count = 1;
        char temp = '1';
        if (n == 1)
            return "1";
        else {
            String prevStr = countAndSay(n - 1);
            int i = 0;
            while (i < prevStr.length()) {
                if (i == 0) {
                    temp = prevStr.charAt(i);
                    i++;
                    continue;
                } else {
                    if (prevStr.charAt(i - 1) == prevStr.charAt(i)) {
                        count++;
                        temp = prevStr.charAt(i);
                    } else {
                        // 该字符与前一个字符不相等
                        // count归1，append至res
                        res.append(Integer.toString(count));
                        res.append(temp);
                        count = 1;
                        temp = prevStr.charAt(i);
                    }
                    i++;
                }
            }
            res.append(Integer.toString(count));
            res.append(prevStr.charAt(prevStr.length() - 1));
        }
        return res.toString();
    }
}
// @lc code=end
