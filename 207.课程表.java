import java.util.LinkedList;
import java.util.Queue;

import jdk.internal.jshell.tool.resources.l10n;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Queue<Integer> queue = new LinkedList<>();
        int[] indegrees = new int[numCourses];
        int[][] adjacency = new int[numCourses][numCourses];
        int counts = numCourses;

        // bfs
        // for (int i = 0; i < prerequisites.length; i++) {
        //     int from = prerequisites[i][1];
        //     int to = prerequisites[i][0];
        //     indegrees[to] = indegrees[to] + 1;
        //     adjacency[from][to] = 1; // 构建邻接矩阵
        // }

        // for (int i = 0; i < indegrees.length; i++) {
        //     if (indegrees[i] == 0)
        //         queue.offer(i);
        // }

        // while (!queue.isEmpty()) {
        //     int poll = queue.poll();
        //     counts--;
        //     for (int i = 0; i < numCourses; i++)
        //         if (adjacency[poll][i] == 1) {
        //             indegrees[i] = indegrees[i] - 1;
        //             if (indegrees[i] == 0)
        //                 queue.offer(i);
        //         }

        // }

        //dfs
        

        return counts == 0;

    }
}
// @lc code=end
