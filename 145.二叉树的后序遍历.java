import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    List<Integer> postorderList = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        voidPostorderTraversal(root);
        return postorderList;
    }

    public void voidPostorderTraversal(TreeNode root) {
        if (root == null)
            return;
        voidPostorderTraversal(root.left);
        voidPostorderTraversal(root.right);
        postorderList.add(root.val);
    }
}
// @lc code=end
