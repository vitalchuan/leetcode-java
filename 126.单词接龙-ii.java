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
        List<List<Integer>> res = new ArrayList<>();

        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return res;

        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);
        Map<String, Set<String>> from = new HashMap<>();

    }

    public boolean bfs(String beginWord, String endWord, Set<String> dict, Map<String, Integer> steps,
            Map<String, Set<String>> from) {
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        steps.put(beginWord, step);

        while (!queue.isEmpty()) {
            String currWord = queue.poll();
            char[] charArray = currWord.toCharArray();

            // 搜索nextWord
            for (int i = 0; i < charArray.length; i++) {
                char origin = charArray[i];
                for (char c = 'a'; c < 'z'; c++) {
                    charArray[i] = c;
                    String nextWord = String.valueOf(charArray);

                    if (!dict.contains(nextWord))
                        continue;

                    // 防止之后重新访问
                    dict.remove(nextWord);
                    // 入队
                    queue.offer(nextWord);

                    from.putIfAbsent(nextWord, new HashSet<>());
                    from.get(nextWord).add(currWord);

                }
            }
        }

    }
}
// @lc code=end
