import java.util.Deque;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 1; i <= currentSize; i++) {
                TreeNode node = queue.poll();
                if (isOrderLeft)
                    deque.offerLast(node.val);
                else
                    deque.offerFirst(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            isOrderLeft = !isOrderLeft;
            res.add(new LinkedList<>(deque));
        }

        return res;
    }
}
// @lc code=end
