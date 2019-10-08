package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for (int[] cp : prerequisites) indegrees[cp[0]]++;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.addLast(i);
        }
        while (!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            numCourses--;
            for (int[] req : prerequisites) {
                if (req[1] == pre && --indegrees[req[0]] == 0) {
                    queue.add(req[0]);
                }
            }
        }
        return numCourses == 0;

    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses];
        int[] flags = new int[numCourses];
        //邻接矩阵 adjacency
        for (int[] cp : prerequisites)
            adjacency[cp[1]][cp[0]] = 1;
        for (int i = 0; i < numCourses; i++) {
            if (dfs(adjacency, flags, i)) return false;
        }
        return true;
    }
//    未被 DFS 访问：i == 0；
//    已被其他节点启动的DFS访问：i == -1；
//    已被当前节点启动的DFS访问：i == 1。

    /**
     * 是否存在环
     *
     * @param adjacency
     * @param flags
     * @param i
     * @return
     */
    private boolean dfs(int[][] adjacency, int[] flags, int i) {
        if (flags[i] == 1) return true;
        if (flags[i] == -1) return false;
        flags[i] = 1;
        for (int j = 0; j < adjacency.length; j++) {
            if (adjacency[i][j] == 1 && dfs(adjacency, flags, j)) return true;
        }
        flags[i] = -1;
        return false;
    }

}
