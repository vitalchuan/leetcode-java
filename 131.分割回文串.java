/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        LinkedList<String> path = new LinkedList<>();

        dfs(s, path, res);
        return res;
    }

    public void dfs(String current, LinkedList<String> path, List<List<String>> res) {
        // 递归终点
        if (current.equals(""))
            res.add(new LinkedList<>(path));

        for (int i = 1; i <= current.length(); i++) {
            String str1 = current.substring(0, i);
            // 判断str1是不是回文
            if (isHuiWen(str1)) {
                path.add(str1);
                String temp = current.substring(i);
                dfs(temp, path, res);
                path.removeLast();
            }
        }
    }

    public boolean isHuiWen(String str) {
        int i = 0, j = str.length() - 1;
        for (int m = 0; m < str.length(); m++)
            if (str.charAt(i + m) != str.charAt(j - m))
                return false;

        return true;
    }
}
// @lc code=end
