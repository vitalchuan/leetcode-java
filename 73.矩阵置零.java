/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int mLen = matrix.length;
        int nLen = matrix[0].length;
        int flag = 1;

        for (int i = 0; i < mLen; i++)
            if (matrix[i][0] == 0)
                flag = 0;
        for (int i = 0; i < nLen; i++)
            if (matrix[0][i] == 0)
                matrix[0][0] = 0;

        for (int i = 1; i < mLen; i++)
            for (int j = 1; j < nLen; j++)
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }

        for (int j = 1; j < nLen; j++)
            if (matrix[0][j] == 0) {
                for (int i = 0; i < mLen; i++)
                    matrix[i][j] = 0;
            }

        for (int i = 1; i < mLen; i++)
            if (matrix[i][0] == 0)
                for (int j = 0; j < nLen; j++)
                    matrix[i][j] = 0;
        if (matrix[0][0] == 0)
            for (int j = 0; j < nLen; j++)
                matrix[0][j] = 0;

        if (flag == 0)
            for (int i = 0; i < mLen; i++)
                matrix[i][0] = 0;
    }
}
// @lc code=end
