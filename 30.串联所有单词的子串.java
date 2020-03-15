import java.util.*;

/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // 暴力法
        List<Integer> res = new LinkedList<>();
        int wordsNum = words.length;
        int wordLen = 0;
        if(words.length != 0)
            wordLen = words[0].length();
        else return res;
        Map<String, Integer> allWords = new HashMap<>();
        for (String word : words) {
            int val = allWords.getOrDefault(word, 0);
            allWords.put(word, val + 1);
        }

        for (int i = 0; i < s.length() - wordsNum * wordLen + 1; i++) {
            Map<String, Integer> hasWords = new HashMap<>();
            int num = 0;
            while (num < wordsNum) {
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                if (allWords.containsKey(word)) {
                    int val = hasWords.getOrDefault(word, 0);
                    if (val >= allWords.getOrDefault(word, 0))
                        break;
                    hasWords.put(word, ++val);
                } else
                    break;
                num++;
            }
            if (num == wordsNum)
                res.add(i);
        }
        return res;
    }
}
// @lc code=end
