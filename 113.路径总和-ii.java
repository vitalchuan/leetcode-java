import java.util.Deque;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode node, int sum) {
        if (node == null)
            return;

        path.offerLast(node.val);
        sum -= node.val;

        if (node.left == null && node.right == null && sum == 0) {
            res.add(new LinkedList<>(path));
        }

        dfs(node.left, sum);
        dfs(node.right, sum);

        sum += node.val;
        path.pollLast();
    }
}
// @lc code=end
