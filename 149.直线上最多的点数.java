import java.util.Map;

import javax.print.attribute.Size2DSyntax;

/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2)
            return n;

        int max = 0;
        Set<Integer> maximums = new HashSet<>();

        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j == i)
                    continue;
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0) {
                    dy = 1;
                } else if (dy == 0)
                    dx = 1;
                else {
                    // dx,dy !=0

                    if (dx < 0) {
                        dx = - dx;
                        dy = - dy;
                    }

                    int GCDxy = gcd(Math.abs(dx), Math.abs(dy));
                    dx /= GCDxy;
                    dy /= GCDxy;
                }
                int val = 20001 * dx + dy;
                map.putIfAbsent(val, 1);
                map.put(val, map.get(val) + 1);
            }

            maximums.add(map.values().stream().max((a1, a2) -> a1 - a2).get());
        }

        return maximums.stream().max((i,j)->i-j).get();
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
// @lc code=end
