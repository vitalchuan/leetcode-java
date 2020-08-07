import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> list = new LinkedList<>();

        String[] strs = path.split("/");

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("..")) {
                if (list.size() != 0)
                    list.removeLast();

            } else if (strs[i].equals(".")) {
            } else if (strs[i].equals("")) {
            } else {
                list.add(strs[i]);
            }
        }
        if(list.size() == 0) return "/";

        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append("/");
            sb.append(str);
        }
        return sb.toString();
    }
}
// @lc code=end
