`35. Search Insert Position`

<https://leetcode.com/problems/search-insert-position/>

`35. 排序数组搜索插入位置`

<https://leetcode-cn.com/problems/search-insert-position/>

## 描述


给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:
````
输入: [1,3,5,6], 5
输出: 2
````
示例 2:
````
输入: [1,3,5,6], 2
输出: 1
````
示例 3:
````
输入: [1,3,5,6], 7
输出: 4
````
示例 4:
````
输入: [1,3,5,6], 0
输出: 0
````

## 思路

二分搜索的典型应用,在数组中搜索第一个不小于的数的位置.


```java
 /**
     * 查找第一个不小于目标值的数字
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1, mid;
        while(low <= high){
            mid = low + (high - low) / 2;
            // 这里忽略等于情况

            // 这里使用mid 和 target比
            if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
```
