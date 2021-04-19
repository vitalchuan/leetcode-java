/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<Integer>();
    for(int binary = 0;binary < 1 << n; binary++){
        gray.add(binary ^ binary >> 1);
    }
    return gray;
    }
}
// @lc code=end

