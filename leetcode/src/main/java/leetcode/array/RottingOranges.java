package leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    /**
     * 测试用空方法
     *
     * @param grid
     * @return
     */
    public int orangesRotting2(int[][] grid) {
        return 0;
    }


    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        while (true) {
            boolean b = false;
            Queue<int[]> badOranges = new LinkedList<int[]>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {

                        rot(grid, i + 1, j, badOranges);
                        rot(grid, i - 1, j, badOranges);
                        rot(grid, i, j + 1, badOranges);
                        rot(grid, i, j - 1, badOranges);
                        if (badOranges.size() > 0) {
                            b = true;
                        }
                        grid[i][j] = -1;

                    }

                }
            }

            if (!b) break;
            while (!badOranges.isEmpty()) {
                int[] t = badOranges.poll();
                grid[t[0]][t[1]] = 2;
            }
            count++;

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }


    void rot(int[][] grid, int i, int j, Queue<int[]> queue) {
        if (i < grid.length && i >= 0 && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            queue.add(new int[]{i, j});
        }
    }

    public static void main(String[] args) {
        new RottingOranges().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
    }
}
