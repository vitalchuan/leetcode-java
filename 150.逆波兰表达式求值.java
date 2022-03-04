import java.util.Deque;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        Set<String> dict = new HashSet<>();
        dict.add("+");
        dict.add("-");
        dict.add("*");
        dict.add("/");

        for (int i = 0; i < tokens.length; i++) {
            if (dict.contains(tokens[i])) {
                int b = deque.removeLast();
                int a = deque.removeLast();
                if ("+".equals(tokens[i]))
                    deque.addLast(a + b);
                else if ("-".equals(tokens[i]))
                    deque.addLast(a - b);
                else if ("*".equals(tokens[i]))
                    deque.addLast(a * b);
                else if ("/".equals(tokens[i]))
                    deque.addLast(a / b);
            } else
                deque.addLast(Integer.parseInt(tokens[i]));
        }
        return deque.peek();

    }
}
// @lc code=end
