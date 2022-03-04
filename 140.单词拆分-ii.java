import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

// @lc code=start
class Solution {
    Set<String> dict;
    Deque<String> deque = new LinkedList<>();

    Deque<String> path = new LinkedList<>();
    List<String> res = new LinkedList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        dfs(0, s);
        return res;

    public void dfs(int startIndex, String s) {
        if (startIndex == s.length()) {
            res.add(listToString(path));
            return;
        }

        for (int i = startIndex + 1; i <= s.length(); i++) {
            String current = s.substring(startIndex, i);
            if (!dict.contains(current))
                continue;
            path.addLast(current);
            dfs(i, s);
            path.removeLast();
        }
    }

    public String listToString(Deque<String> path) {
        Iterator<String> it = path.iterator();
        StringBuilder sb = new StringBuilder("");
        if (!it.hasNext())
            return sb.toString();
        sb.append(it.next());
        while (it.hasNext())
            sb.append(" " + it.next());
        return sb.toString();
    }
}
// @lc code=end
