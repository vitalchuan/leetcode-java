import java.util.List;
/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    //递归
    // public boolean isSymmetric(TreeNode root) {
    //     return isSameTree(root.left, root.right);
    // }

    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     if (p == null && q == null)
    //         return true;
    //     else if (p == null && q != null || p != null && q == null)
    //         return false;
    //     else {
    //         // pq都不为null
    //         if (p.val != q.val)
    //             return false;
    //         return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    //     }
    // }
    

    //队列
}
// @lc code=end
