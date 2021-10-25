import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // bfs建图
        Map<String, Integer> visited = new HashMap<>();
        Map<String, List<String>> from = new HashMap<>();

        for (String word : wordList) {
            visited.put(word, 0);
        }
        visited.remove(beginWord);

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            step++;
            for (int m = 0; m < queue.size(); m++) {
                String current = queue.poll();
                visited.put(current, 2);

                char[] charArr = current.toCharArray();
                for (int i = 0; i < charArr.length; i++) {
                    char origin = charArr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        charArr[i] = ch;
                        String next = String.valueOf(charArr);

                        if (visited.containsKey(next) && visited.get(next) != 2) {
                            // 把next加入queue，
                            if (visited.get(next) == 0) {
                                queue.offer(next);
                                visited.put(next, 1);
                            }
                            // 加入建图map中
                            from.putIfAbsent(current, new ArrayList<>());
                            from.get(current).add(next);
                        }
                    }
                    charArr[i] = origin;
                }
            }

        }

        List<List<String>> res = new LinkedList<>();
        List<String> path = new LinkedList<>();

        dfs(from, beginWord, endWord, path, res);
        return res;
    }

    public void dfs(Map<String, List<String>> from, String current, String endWord, List<String> path,
            List<List<String>> res) {
        if (current.equals(endWord)) {
            res.add(path);
            return;
        }
        if (!from.containsKey(current))
            return;
        List<String> nexts = from.get(current);

        for (String next : nexts) {
            path.add(next);
            dfs(from, next, endWord, path, res);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end
