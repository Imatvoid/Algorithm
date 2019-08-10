33. Search in Rotated Sorted Array

<https://leetcode.com/problems/search-in-rotated-sorted-array/>

33. 搜索旋转排序数组

<https://leetcode-cn.com/problems/search-in-rotated-sorted-array/>


## 描述
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组` [0,1,2,4,5,6,7] `可能变为` [4,5,6,7,0,1,2]` )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:
``````
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
``````
示例 2:
``````
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
``````

## 有序数组二分查找
复杂度 logn     
核心思想 判断mid 舍弃一边    

``````

0　　1　　2　　 4(mid)　　5　　6　　7

7　　0　　1　　 2(mid)　　4　　5　　6

6　　7　　0　　 1(mid)　　2　　4　　5

5　　6　　7　　 0(mid)　　1　　2　　4

4　　5　　6　　 7(mid)　　0　　1　　2

2　　4　　5　　 6(mid)　　7　　0　　1

1　　2　　4　　 5(mid)　　6　　7　　0
``````

二分搜索法的关键在于获得了中间数后，判断下面要搜索左半段还是右半段，我们观察上面    
可以观察出规律:
如果中间的数小于最右边的数,则右半段是有序的

若中间数大于最右边数，则左半段是有序的，我们只要在有序的半段里用   

首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了

```java
 public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            //左边有序 小 - 大
            if (nums[mid] > nums[right]) {

                if (nums[left] <= target && nums[mid] > target) {
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边有序
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid-1;
                }
            }
        }

        return -1;

    }
```