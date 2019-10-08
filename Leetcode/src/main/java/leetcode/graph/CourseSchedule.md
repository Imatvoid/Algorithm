`207. Course Schedule`

<https://leetcode.com/problems/course-schedule/>

`207. 课程表`

<https://leetcode-cn.com/problems/course-schedule/>

## 描述

现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？

示例 1:
``````
输入: 2, [[1,0]] 
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
``````
示例 2:
``````
输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
``````
说明:

输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
提示:
``````
这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
拓扑排序也可以通过 BFS 完成。
``````

## 思路
本题可约化为：课程安排图是否是 有向无环图(DAG)。即课程间规定了前置条件，但不能构成任何环路，否则课程前置条件将不成立。

思路是通过 拓扑排序 判断此课程安排图是否是 有向无环图(DAG)。

拓扑排序是对 DAG 的顶点进行排序，使得对每一条有向边 (u,v)，均有 u（在排序记录中）比 v 先出现。亦可理解为对某点 v 而言，

只有当 v 的所有源点均出现了，v 才能出现。



## BFS
生成 入度表`indegrees`

从没有限制条件的课程开始遍历。

```java
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
```
## DFS

借助一个标志列表 flags，用于判断每个节点 i （课程）的状态：

- 未被 DFS 访问：i == 0；     
- 已被其他节点启动的DFS访问：i == -1；    
- 已被当前节点启动的DFS访问：i == 1。     
对 numCourses 个节点依次执行 DFS，判断每个节点起步 DFS 是否存在环，若存在环直接返回 False。

DFS 流程终止条件：
当 flag[i] == -1，说明当前访问节点已被其他节点启动的 DFS 访问，无需再重复搜索，直接返回 True。

当 flag[i] == 1，说明在本轮 DFS 搜索中节点 i 被第 2 次访问，即 课程安排图有环，直接返回 False。

将当前访问节点 i 对应 flag[i] 置 11，即标记其被本轮 DFS 访问过；

递归访问当前节点 i 的所有邻接节点 j，当发现环直接返回 False；

当前节点所有邻接节点已被遍历，并没有发现环，则将当前节点 flag 置为 -1 并返回 True。

若整个图 DFS 结束并未发现环，返回 True。
复杂度分析：

时间复杂度 O(N+M)：遍历一个图需要访问所有节点和所有临边，N和M 分别为节点数量和临边数量；

空间复杂度 O(N)，为建立邻接矩阵所需额外空间。




```java

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
```
