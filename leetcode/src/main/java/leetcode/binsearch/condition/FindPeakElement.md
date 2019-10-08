`162. Find Peak Element`

<https://leetcode.com/problems/find-peak-element/>

`162. 寻找峰值`

<https://leetcode-cn.com/problems/find-peak-element/>

## 描述

峰值元素是指其值大于左右相邻值的元素。

给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。

数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞。

示例 1:
```
输入: nums = [1,2,3,1]
输出: 2
解释: 3 是峰值元素，你的函数应该返回其索引 2。
```
示例 2:
```
输入: nums = [1,2,1,3,5,6,4]
输出: 1 或 5 
解释: 你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。
说明:
```
你的解法应该是 O(logN) 时间复杂度的。

## 思路

二分的条件：

首先要注意题目条件，在题目描述中出现了 `nums[-1] = nums[n] = -∞`，这就代表着 只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值

根据上述结论，我们就可以使用二分查找找到峰值

比如{1,2,1,3,5,6,4} 找到中点元素3,3<5,从后半部分数组继续找.

如果5后边的元素小于5,则峰值已找到.例子中是6,可以继续找,只要有一个元素下降一下就可以找到峰值.

就算一直递增,那么倒数第二个元素和倒数第一个元素以及`nums[n] = -∞`也构成了峰值。

```java
/**
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1) return 0;
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid+1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //System.out.println("left:"+left+"right:"+right);
        return left;
    }
```