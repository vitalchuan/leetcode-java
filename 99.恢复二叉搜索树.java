import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        int[] resArray = new int[res.size()];

        for (int i = 0; i < res.size(); i++)
            resArray[i] = res.get(i);
        int[] indexs = findTwoSwapped(resArray);

        recover(root, indexs[0], indexs[1]);

    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    // 第一个比后面大的 第二个比前面小的
    public int[] findTwoSwapped(int[] nums) {
        int a = -1, b = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (a == -1)
                    a = i - 1;
                else
                    b = i;
            }
        }
        if (b == -1)
            return new int[] { a, a + 1 };
        else
            return new int[] { a, b };
    }

    public void recover(TreeNode root, int x, int y) {
        if (root == null)
            return;
        if (root.val == x || root.val == y) {
            root.val = root.val == x ? y : x;
        }

        recover(root.left, x, y);
        recover(root.right, x, y);
    }
}
// @lc code=end
