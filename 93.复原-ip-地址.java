import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        LinkedList<String> cur = new LinkedList<>();

        dfs(res, cur, s, 0, 0);

        return res;
    }

    public void dfs(List<String> res, LinkedList<String> cur, String s, int completedSeg, int usedNum) {
        if (completedSeg < 4) {
            if (s.length() - usedNum <= 0)
                return;
            else {
                for (int i = usedNum + 1; i < s.length(); i++) {
                    // 如果第一位是0 则return
                    if (s.charAt(usedNum) == '0')
                        return;
                    String str = s.substring(usedNum, i);
                    if (Integer.parseInt(str) > 255)
                        return;
                    cur.add(str);
                    dfs(res, cur, s, completedSeg + 1, i);
                    cur.removeLast();
                }
            }
        } else {
            if (usedNum == s.length())
                res.add(list2String(cur));
        }
    }

    public String list2String(List<String> list) {
        // list不为空
        StringBuilder sb = new StringBuilder();
        for (String e : list) {
            sb.append("." + e);
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }
}
// @lc code=end
