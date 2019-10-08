`81. Search in Rotated Sorted Array II`

<https://leetcode.com/problems/search-in-rotated-sorted-array-ii/>

`81. 搜索旋转排序数组 II`

<https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/>

## 描述

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组` [0,0,1,2,2,5,6] `可能变为 `[2,5,6,0,0,1,2] `)。

编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

示例 1:
```
输入: nums = [2,5,6,0,0,1,2], target = 0
输出: true
```
示例 2:
```
输入: nums = [2,5,6,0,0,1,2], target = 3
输出: false
```
进阶:

这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。

这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？


## 思路

 这道题与之前`Search in Rotated SortedArray`类似，问题只在于存在dupilcate。
 
 那么和之前那道题的解法区别就是，不能通过比较`A[mid]`和边缘值来确定哪边是有序的，会出现`A[mid]`与边缘值相等的状态。
 
 所以，解决方法就是对于`A[mid]==A[low]`和`A[mid]==A[high]`单独处理。
 
 当中间值与边缘值相等时，让指向边缘值的指针分别往前移动，忽略掉这个相同点，再用之前的方法判断即可。
 
 这一改变增加了时间复杂度，试想一个数组有同一数字组成{1，1，1，1，1}，target=2,
 
 那么这个算法就会将整个数组遍历，时间复杂度由O(logn)升到O(n)
 
 
 ```java
 public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] <= nums[right-1]) {
                // 右边有序
                if (nums[mid] == nums[right-1]) {
                    right--;
                    continue;
                }

                if (nums[mid] < target && nums[right-1] >= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                // 左边有序
                if (nums[mid] == nums[left]) {
                    left++;
                    continue;
                }

                if (nums[left] <= target && nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;

    }
 ```