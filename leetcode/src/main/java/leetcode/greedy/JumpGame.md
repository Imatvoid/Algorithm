## 55. Jump Game





### Desc

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

**Example 1:**

```
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

**Example 2:**

```
Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
```



### 描述

跳远游戏。

数组里的每个元素表示从该位置可以跳出的最远距离，要求问从第一个元素（index=0）开始，能否达到数组的最后一个元素，这里认为最后一个元素为**终点**。这里是到达，说明超过也行。





### 思路

贪心算法，计算出某个点时 能够跳出的最大距离（当前的最大值和（当前点+能跳出的最大距离）的较大的值），如果能跳出的最大距离大于最后一个点的位置，那么返回true，能到达；如果到达当前点后，不能在往后跳，那么不能达到最后点，返回false。

不断更新最大距离