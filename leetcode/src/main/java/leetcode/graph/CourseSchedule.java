package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    int res[];
    int k;
    int[] flag2;
    /**
     * 有向图
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        res = new int [numCourses];
        k=numCourses-1;

        // 不允许创建泛型数组
        ArrayList[] graph = new ArrayList[numCourses];
        int[] flag = new int[numCourses];
        flag2 = new int[numCourses];

        // 使用矩阵存储有向图
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < graph.length; i++) {
            if (!dfs(graph, flag, i)) {
                return false;
            }

        }

        return  true;

    }

    boolean dfs(ArrayList[] graph, int[] flag, int i) {

        if (flag[i] == 0) {

            flag[i] = -1;
            // destination
            ArrayList list = graph[i];
            for (int j = 0; j < list.size(); j++) {
                if (!dfs(graph, flag, (int) list.get(j))) {
                    return false;
                }
            }
            // 这里是0 也可以 但是会浪费 已经走过的地方，它的所有可能路线也遍历过，再走浪费。
            flag[i] = k;

            if (flag2[i] == 0) {
                res[k--] = i;
                flag2[i] = 1;
            }
        }else {
            if (flag[i] == -1)  //cycle detected if hitting a visiting course again.
                return false;
        }
        return true;
    }


    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count=0;

        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        for(int i=0; i<prerequisites.length;i++){
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }

        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses)
            return true;
        else
            return false;
    }
}
