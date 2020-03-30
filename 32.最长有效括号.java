import java.util.Arrays;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        // if (s.length() < 2) {
        // return 0;
        // }
        // Stack<Integer> stack = new Stack<>();
        // int max = 0;

        // stack.add(-1);

        // for (int i = 0; i < s.length(); i++) {
        // if (s.charAt(i) == '(') {
        // stack.push(i);
        // } else {
        // stack.pop();
        // if (stack.isEmpty()) {
        // stack.push(i);
        // } else {
        // max = max > (i - stack.peek()) ? max : (i - stack.peek());
        // }

        // }

        // }
        // return max;

        /**
         * 方法二：动态规划
         */
        int maxLen = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(')
                    dp[i] = i > 1 ? dp[i - 2] + 2 : 2;
                else {
                    // s.charAt(i-1) = ')'
                    if ((i - dp[i - 1] - 1) >= 0 && (s.charAt(i - dp[i - 1] - 1) == '('))
                        dp[i] = i - dp[i - 1] - 2 >= 0 ? dp[i - 1] + 2 + dp[i - dp[i - 1] - 2] : dp[i - 1] + 2;
                    // else
                    // //s.charAt(i-dp[i-1]-1) == ")"
                    // dp[i] = 0;
                }
                maxLen = maxLen > dp[i] ? maxLen : dp[i];
            }
        }
        return maxLen;
    }
}
// @lc code=end
