## 统计

| 题目  | 描述 |    |
|---|  ---  | --- |
| CountOfSmallerNumbersAfterSelf  | 在自己右边找出比自己小的数   |   |
| SearchInsertPosition  | 被上面的题包含了  |   |
| FindPeakElement  | 找峰值元素,难点是二分舍弃的条件  |   |
| FindMinimumInRotatedSortedArray  | 在旋转数组中查找最小值 |   |
| MedianOfTwoSortedArrays  | 两个排序数组的中位数 (m+n+1)/2  (m+n+2)/2 |   |
| SearchA2DMatrix  | 二维数组做普通二分 |   |
| SearchA2DMatrixII  | 从左下往右上找. |   |

基础复习:

BinSearch

典型:

CountOfSmallerNumbersAfterSelf 找插入位置.

评估二分舍弃的条件 

FindPeakElement

FindMinimumInRotatedSortedArray 在旋转数组中查找最小值 看哪边有序


SearchA2DMatrix   mid / col;  mid % col;

KthSmallestElementinaSortedMatrix

**Median of Two Sorted Arrays** 经典题目 left = (m + n + 1) / 2, right = (m + n + 2) / 2;
