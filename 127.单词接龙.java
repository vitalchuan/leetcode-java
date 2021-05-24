import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;
        set.remove(beginWord);

        // 建立图
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 广度优先搜索 BFS
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int currentSize = queue.size();
            for (int m = 0; m < currentSize; m++) {
                String currentWord = queue.poll();
                char[] charArray = currentWord.toCharArray();

                // 对currentWord的在set的,未访问过的变种作入队操作
                // 若变种等于 endWord，则直接返回
                for (int n = 0; n < currentWord.length(); n++) {
                    char origin = charArray[n];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        charArray[n] = ch;
                        String nextWord = String.valueOf(charArray);

                        // set中包含 且 visited中 不包含
                        if (set.contains(nextWord) && !visited.contains(nextWord)) {
                            if (nextWord.equals(endWord))
                                return step+1;
                            else {
                                visited.add(nextWord);
                                queue.offer(nextWord);
                            }
                        }
                    }
                    charArray[n] = origin;
                }
            }
        }
        return 0;
    }
}
// @lc code=end
