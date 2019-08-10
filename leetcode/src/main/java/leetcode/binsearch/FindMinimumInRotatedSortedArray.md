153. Find Minimum in Rotated Sorted Array

<https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/>

153. 寻找旋转排序数组中的最小值

<https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/>


## 描述

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组` [0,1,2,4,5,6,7] `可能变为 `[4,5,6,7,0,1,2] `)。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:
``````
输入: [3,4,5,1,2]
输出: 1
``````
示例 2:
``````
输入: [4,5,6,7,0,1,2]
输出: 0
``````

## 发现规律 
``````

0　　1　　2　　 4(mid)　　5　　6　　7

7　　0　　1　　 2(mid)　　4　　5　　6

6　　7　　0　　 1(mid)　　2　　4　　5

5　　6　　7　　 0(mid)　　1　　2　　4

4　　5　　6　　 7(mid)　　0　　1　　2

2　　4　　5　　 6(mid)　　7　　0　　1

1　　2　　4　　 5(mid)　　6　　7　　0
``````


比较 nums[mid] 和 nuns[right]

nums[mid] > nums[right] 数组左边有序 小 - 大

否则 数组右边有序 小 - 大
```java
package leetcode.binsearch;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if(nums.length == 1){
            return  nums[0];
        }
        int left = 0 ;
        int right = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(left<right){
            // 防止溢出
            int mid =left + (right-left)/2;
            //左边有序 小 - 大
            if(nums[mid]>nums[right]){
                min = nums[left] < min ? nums[left] : min;
                left = mid + 1;
            }else {
            //右边有序 小 - 大
                min = nums[mid] < min ? nums[mid] : min;
                right = mid;
            }

        }
        return min;


    }

}

```