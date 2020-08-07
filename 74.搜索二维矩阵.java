/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int mLen = matrix.length;
        if (mLen == 0)
            return false;
        int nLen = matrix[0].length;

        int[] array = new int[mLen * nLen];
        for (int i = 0; i < mLen; i++)
            for (int j = 0; j < nLen; j++)
                array[i * nLen + j] = matrix[i][j];

        return binarySearch(array, target);
    }

    public boolean binarySearch(int[] array, int target) {
        int left, right, medium;
        left = 0;
        right = array.length - 1;
        while (left <= right) {
            medium = (left + right) / 2;
            if (array[medium] == target)
                return true;
            else if (array[medium] < target)
                left = medium + 1;
            else if (array[medium] > target)
                right = medium - 1;
        }
        return false;
    }

}
// @lc code=end

