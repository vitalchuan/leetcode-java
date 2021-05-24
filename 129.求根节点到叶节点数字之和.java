/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public static int sum = 0;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        int preSum = 0;
        dfs(root, preSum);
        return sum;
    }

    public void dfs(TreeNode currentNode, int preSum) {
        preSum = preSum * 10 + currentNode.val;

        // 是叶节点
        if (currentNode.left == null && currentNode.right == null) {
            sum += preSum;
            return;
        }

        if (currentNode.left != null)
            dfs(currentNode.left, preSum);
        if (currentNode.right != null)
            dfs(currentNode.right, preSum);
    }
}
// @lc code=end
