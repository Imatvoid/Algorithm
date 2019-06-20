package leetcode.medium;

class NumberOfIslands {


    int[][] flags;
    int count = 0;

    public int numIslands(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }
        flags = new int[grid.length][grid[0].length];


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && flags[i][j] == 0) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;


    }

    void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x > grid.length - 1) {
            return;
        }
        if (y < 0 || y > grid[0].length - 1) {
            return;
        }
        if (grid[x][y] == '0' || flags[x][y] == 1) {
            return;
        }

        flags[x][y] = 1;
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x - 1, y);
        dfs(grid, x, y - 1);


    }

    public static void main(String[] args) {
        new NumberOfIslands().numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}});
    }
}
