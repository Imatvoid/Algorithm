`Search a 2D Matrix`

<https://leetcode.com/problems/search-a-2d-matrix/>

`74. 搜索二维矩阵`

<https://leetcode-cn.com/problems/search-a-2d-matrix/>

## 描述

编写一个高效的算法来判断 `m x n `矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1:
```
输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true
```
示例 2:

```
输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
输出: false
```

## 思路

就是普通二分,只不过从一维数组变成了二维数组。

tips:   mid / col;  mid % col;

注意边界条件

```java
  public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col;

        while(left < right) {
            int mid = left + (right - left) / 2;
            int r = mid / col;
            int c = mid % col;
            if(matrix[r][c] == target) {
                return true;
            }
            if(matrix[r][c] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }


```


