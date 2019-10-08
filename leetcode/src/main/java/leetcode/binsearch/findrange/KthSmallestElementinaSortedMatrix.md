`378. Kth Smallest Element in a Sorted Matrix`

<https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/>

`378. 有序矩阵中第K小的元素`

<https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/>

## 描述

给定一个 `n x n `矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
请注意，它是排序后的第k小元素，而不是第k个元素。

示例:
```
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。
说明:
你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
```

## 思路
find range类型的二分.

```

_ _ _ K K _ p_ _ _ N-1 N 

``` 

```java
/**
     * 尽量少的空间复杂度,
     * 查找第一个不小于目标值的数字,
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int L = matrix[0][0], R = matrix[n - 1][n - 1];
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            int temp = search_lower_than_mid(matrix, n, mid);
            if (temp < k) L = mid + 1;
            else R = mid;
        }
        return L;
    }

    /**
     * 返回的是第一个大于x的数，前面数的个数。
     * @param matrix
     * @param n
     * @param x
     * @return
     */
    private static int search_lower_than_mid(int[][] matrix, int n, int x) {
        int i = n - 1, j = 0, cnt = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= x) {
                j++;
                cnt += i + 1;
            } else i--;
        }
        return cnt;
    }
```

