package leetcode.graph;

import java.util.ArrayList;

public class CourseScheduleII {
    int res[];
    int k;
    int[] flag2;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
                return new int[]{};
            }

        }

        return  res;

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


    public static void main(String[] args) {
        new CourseScheduleII().findOrder(2,
                new int[][]{{1, 0}});
    }

    //implementing my own version of IntHolder to store results
    class IntHolder{
        public int value;
        public IntHolder(int a){
            this.value = a;
        }
    }
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] visited = new int[numCourses];
        int[] results = new int[numCourses];
        //construct the leetcode.graph structure
        for (int i = 0; i < prerequisites.length; i++){
            if(prerequisites[i].length == 2){
                if (graph[prerequisites[i][0]] == null)
                    graph[prerequisites[i][0]] = new ArrayList<Integer>();
                graph[prerequisites[i][0]].add(prerequisites[i][1]);
            }
        }
        IntHolder order = new IntHolder(0);
        //do leetcode.dfs on the leetcode.graph
        for (int i = 0; i < numCourses; i++){
            if(!doDfs(graph, visited, i, order, results)){
                results = new int[0];
                return results;
            }
        }
        return results;
    }

    //doDfs will return false if cycle is detected
    private boolean doDfs(ArrayList<Integer>[] graph, int[] visited,
                          int visitingCourse, IntHolder order, int[] results){
        if (visited[visitingCourse] == 0){ //do DFS only when not visited before
            visited[visitingCourse] = -1;      //visiting course assign a -1 value
            if (graph[visitingCourse] != null){
                for (Integer d: graph[visitingCourse]){
                    if(!doDfs(graph, visited, d, order, results))
                        return false;
                }
            }
            visited[visitingCourse] = ++order.value;   //visited course assign an order value
            results[order.value-1] = visitingCourse;   //record the visiting course its correct order in the result
        } else {
            if (visited[visitingCourse] == -1)  //cycle detected if hitting a visiting course again.
                return false;
        }
        return true;
    }

}
