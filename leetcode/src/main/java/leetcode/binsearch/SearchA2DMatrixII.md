`240. Search a 2D Matrix II`

<https://leetcode.com/problems/search-a-2d-matrix-ii/>

`240. 搜索二维矩阵 II`

<https://leetcode-cn.com/problems/search-a-2d-matrix-ii/>

## 描述
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
示例:
```
现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。
```

## 思路

因为每一行递增，每一列递增。

所以从右上角往左下角找或者从左下角往右上角找。每次比较可以排除一行或者一列，时间复杂度为O(m+n)


(如果从左上角或者右下角开始,则会有两个方向,难以选择)
```java
 public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0 ) {
            return false;
        }

        int row = matrix.length - 1, column = matrix[0].length - 1;
        int x = row, y = 0;

        while (x >= 0 && y <= column) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                return true;
            }
        }

        return false;
    }
```
