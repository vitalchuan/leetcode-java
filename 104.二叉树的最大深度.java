/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // List<List<Integer>> res = new ArrayList<>();
        // if (root == null)
        //     return 0;

        // Queue<TreeNode> queue = new LinkedList<>();

        // int currentSize = 0;

        // queue.offer(root);
        // while (!queue.isEmpty()) {
        //     currentSize = queue.size();
        //     List<Integer> list = new ArrayList<>();
        //     for (int i = 1; i <= currentSize; i++) {
        //         TreeNode node = queue.poll();
        //         list.add(node.val);
        //         if (node.left != null)
        //             queue.offer(node.left);
        //         if (node.right != null)
        //             queue.offer(node.right);
        //     }
        //     res.add(list);
        // }
        // return res.size();

        //递归解法
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
// @lc code=end

