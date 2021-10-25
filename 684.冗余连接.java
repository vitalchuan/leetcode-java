/*
 * @lc app=leetcode.cn id=684 lang=java
 *
 * [684] 冗余连接
 */

// @lc code=start
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = edges.length;

        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            int aRoot = unionFind.find(edges[i][0]);
            int bRoot = unionFind.find(edges[i][1]);

            if (aRoot != bRoot)
                unionFind.map.put(aRoot, bRoot);
            else {
                return edges[i];
            }
        }

        return new int[0];
    }

    static class UnionFind {
        public Map<Integer, Integer> map = new HashMap<>();
        public int counts = 0;

        public void add(int n) {
            map.put(n, n);
        }

        public UnionFind(int n) {
            for (int i = 1; i <= n; i++) {
                add(i);
            }
        }

        public int find(int n) {
            while (map.get(n) != n) {
                n = map.get(n);
            }
            return n;
        }

        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);

            if (aRoot == bRoot)
                return;

            counts--;
            map.put(aRoot, bRoot);
        }
    }
}
// @lc code=end
