/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

    }

    public TreeNode buildTree(int[] preorder,int pStart,int pEnd, int[] inorder, int iStart, int iEnd){
        if(pStart == pEnd) return null;

        TreeNode root = new TreeNode(preorder[pStart]);
        int pLeftStart = pStart + 1;

        
        //在inorder中找到root.val
        for(int i=iStart;i<iEnd;i++){
            if(inorder[i] == root.val){

            }
        }

        return root;
    }
}
// @lc code=end

