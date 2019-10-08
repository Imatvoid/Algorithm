package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class CourseScheduleII {
    /**
     * BFS比较简单
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int[] cp : prerequisites) {
            inDegree[cp[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            list.add(course);
            for (int[] cp : prerequisites) {
                if (cp[1] == course && --inDegree[cp[0]] == 0) {
                    queue.add(cp[0]);
                }
            }
        }
        if (list.size() != numCourses) return new int[0];
        int[] res = new int[numCourses];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);

        return res;
    }

    public static void main(String[] args) {
        new CourseScheduleII().findOrder(2, new int[][]{{0, 1}, {1, 0}});
    }


    public int[] findOrderDFS(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses];
        int[] flags = new int[numCourses];
        //邻接矩阵 adjacency
        for (int[] cp : prerequisites)
            adjacency[cp[1]][cp[0]] = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (dfs(adjacency, flags, i, stack)) return new int[0];
        }
        assert stack.size() == numCourses;
        int[] ret = new int[numCourses];
        // 想想要怎么得到结论，我们的 dfs 是一致将后继结点进行 dfs 的
        // 所以压在栈底的元素，一定是那个没有后继课程的结点
        // 那个没有前驱的课程，一定在栈顶，所以课程学习的顺序就应该是从栈顶到栈底
        // 依次出栈就好了
        for (int i = 0; i < numCourses; i++) {
            ret[i] = stack.pop();
        }
        return ret;


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
    private boolean dfs(int[][] adjacency, int[] flags, int i, Stack<Integer> stack) {
        if (flags[i] == 1) return true;
        if (flags[i] == -1) return false;
        flags[i] = 1;
        for (int j = 0; j < adjacency.length; j++) {
            if (adjacency[i][j] == 1 && dfs(adjacency, flags, j,stack)) return true;
        }
        stack.add(i);
        flags[i] = -1;
        return false;
    }

}
