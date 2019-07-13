## 54. Spiral Matrix



### Desc

Given a matrix of *m* x *n* elements (*m* rows, *n* columns), return all elements of the matrix in **spiral**(螺旋形的,n,v) order.

**Example 1:**

```
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
```

**Example 2:**

```
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
```



### 描述

螺旋矩阵





### 思路（human）

确定上下左右四条边的位置，那么初始化的时候，上边up就是0，下边down就是m-1，左边left是0，右边right是n-1。然后我们进行while循环，先遍历上边，将所有元素加入结果res，然后上边下移一位，如果此时上边大于下边，说明此时已经遍历完成了，直接break。同理对于下边，左边，右边，依次进行相对应的操作，这样就会使得坐标很有规律，并且不易出错。