## 42. Trapping Rain Water

### Desc

Given *n* non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

![img](https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png)
The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. **Thanks Marcos** for contributing this image!

**Example:**

```
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
```



## 描述

找坑接雨水


## 思路

Indeed this question can be solved in one pass and O(1) space, but it's probably hard to come up with in a short interview. If you have read the stack O(n) solution for Largest Rectangle in Histogram, you will find this solution is very very similar.

The main idea is : if we want to find out how much water on a bar(bot), we need to find out the left larger bar's index (il), and right larger bar's index(ir), so that the water is (min(A[il],A[ir])-A[bot])*(ir-il-1), use min since only the lower boundary can hold water, and we also need to handle the edge case that there is no il.

To implement this we use a stack that store the indices with decreasing bar height, once we find a bar who's height is larger, then let the top of the stack be bot, the cur bar is ir, and the previous bar is il.



