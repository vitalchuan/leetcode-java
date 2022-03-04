import java.util.*;

/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {
    TrieNode root = new TrieNode();

    public class TrieNode {
        int end;
        Map<Character, TrieNode> next;

        public TrieNode() {
            end = 0;
            next = new HashMap<>();
        }
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] letters = word.toCharArray();
        TrieNode prevNode = root;

        for (int i = 0; i < letters.length; i++) {
            Set<Character> set = prevNode.next.keySet();
            if (! set.contains(letters[i])) {
                // 当前节点并不在next中
                TrieNode node = new TrieNode();
                prevNode.next.put(letters[i], node);
                prevNode = node;
            } else {
                // 当前节点在next中
                prevNode = prevNode.next.get(letters[i]);
            }

            if (i == letters.length - 1)
                prevNode.end++; // 如果是最后一个字母，则该节点的end+1
        }
    }

    public boolean search(String word) {
        char[] letters = word.toCharArray();
        int len = word.length();
        int i = 0;
        TrieNode prevNode = root;
        while (prevNode.next.size() != 0 && i < len) {
            if (prevNode.next.keySet().contains(letters[i])) {
                if (i == len - 1) {
                    if (prevNode.next.get(letters[i]).end != 0) return true;
                    else return false;
                }
                prevNode = prevNode.next.get(letters[i]);
                i++;
            } else
                return false;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        char[] letters = prefix.toCharArray();
        int len = prefix.length();
        int i = 0;
        TrieNode prevNode = root;
        while (prevNode.next.size() != 0 && i < len) {
            if (prevNode.next.keySet().contains(letters[i])) {
                if (i == len - 1)
                    return true;
                prevNode = prevNode.next.get(letters[i]);
                i++;
            } else
                return false;
        }
        return false;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end
