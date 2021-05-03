/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder, int poStart, int poEnd) {
        if (iStart == iEnd)
            return null;
        TreeNode root = new TreeNode(postorder[poEnd - 1]);
        if (iEnd - iStart == 1)
            return root;
        int iLeftStart = 0, iLeftEnd = 0, iRightStart = 0, iRightEnd = 0;
        int poLeftStart = 0, poLeftEnd = 0, poRightStart = 0, poRightEnd = 0;

        for (int i = iEnd - 1; i >= iStart; i--) {
            if (inorder[i] == root.val) {
                iLeftStart = iStart;
                iLeftEnd = i;
                iRightStart = i + 1;
                iRightEnd = iEnd;
                break;
            }
        }

        int leftLen = iLeftEnd - iLeftStart;
        poLeftStart = poStart;
        poLeftEnd = poLeftStart + leftLen;
        poRightStart = poLeftEnd;
        poRightEnd = poEnd - 1;

        root.left = buildTree(inorder, iLeftStart, iLeftEnd, postorder, poLeftStart, poLeftEnd);
        root.right = buildTree(inorder, iRightStart, iRightEnd, postorder, poRightStart, poRightEnd);
        return root;
    }
}
// @lc code=end
