import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    List<Integer> preOrder = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorderTraversal1(root);
        return preOrder;
    }

    public void preorderTraversal1(TreeNode root) {
        if (root == null)
            return;
        preOrder.add(root.val);
        preorderTraversal1(root.left);
        preorderTraversal1(root.right);
    }
}
// @lc code=end
