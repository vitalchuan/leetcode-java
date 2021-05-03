/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pEnd == pStart)
            return null;
        TreeNode root = new TreeNode(preorder[pStart]);
        // if (pEnd - pStart == 1)
        //     return root;
        
        int pLeftStart = pStart + 1;
        int pLeftEnd = pLeftStart;
        int pRightStart = pLeftStart;
        int pRightEnd = pLeftStart;

        int iLeftStart = iStart;
        int iLeftEnd = iLeftStart;
        int iRightStart = iLeftStart;
        int iRightEnd = iEnd;

        int leftLen, rightLen;

        // 在inorder中找到root.val
        for (int i = iStart; i < iEnd; i++) {
            if (inorder[i] == root.val) {
                iLeftEnd = i;
                iRightStart = i + 1;
                break;
            }
        }

        leftLen = iLeftEnd - iLeftStart;

        pLeftStart = pStart + 1;
        pLeftEnd = pLeftStart + leftLen;
        pRightStart = pLeftEnd;
        pRightEnd = pEnd;

        root.left = buildTree(preorder, pLeftStart, pLeftEnd, inorder, iLeftStart, iLeftEnd);
        root.right = buildTree(preorder, pRightStart, pRightEnd, inorder, iRightStart, iRightEnd);
        return root;
    }
}
// @lc code=end
