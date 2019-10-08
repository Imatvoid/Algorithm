`210. Course Schedule II`

<https://leetcode.com/problems/course-schedule-ii/>

`210. 课程表 II`

<https://leetcode-cn.com/problems/course-schedule-ii/>

## 描述

现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。

可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。

示例 1:
``````
输入: 2, [[1,0]] 
输出: [0,1]
解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
``````
示例 2:

``````
输入: 4, [[1,0],[2,0],[3,1],[3,2]]
输出: [0,1,2,3] or [0,2,1,3]
解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
``````
说明:

输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。


## 思路

和CourseSchedule一样 只是加入了保存顺序


## BFS
```java
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
```