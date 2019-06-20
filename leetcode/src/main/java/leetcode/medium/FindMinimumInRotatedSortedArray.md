## FindMinimumInRotatedSortedArray

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: 
[3,4,5,1,2] 

Output: 1

Example 2:

Input: 
[4,5,6,7,0,1,2]

Output: 0

### 发现规律 

比较 nums[mid] 和 nuns[end]

nums[mid] > nums[end] 数组左边有序 小 - 大

否则 数组右边有序 小 - 大