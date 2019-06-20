# 4. Median of Two Sorted Arrays



## Desc

There are two sorted arrays **nums1** and **nums2** of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume **nums1** and **nums2** cannot be both empty.

**Example 1:**

```
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
```

**Example 2:**

```
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
```



## 描述

给定两个有序数组,找出这个集合(两个有序数组)的中位数

要求时间复杂度O(log (m+n)).

## 思路

### trick

首先让我们有一个小的trick,把问题转化下.

对于一个有序数组A,长度为length.

则中位数等于第 `(length+1)/2` 个数字, 第`(length+2)/2`个数字 的和除以2

如果A= {1 2 3 4 5}, len = 5 是个奇数.(length+1)/2=3   (length+2)/2 =3

数组A 的中位数确实是第3个数加自己除以2

如果A= {1 2 3 4 5 6}, len = 6是个偶数. (length+1)/2=3   (length+2)/2 =4

数组A 的中位数确实是第3个数字加4四个数字的和除以2

### 问题转化

所以我们的问题转化为了,在数组A,B中求第`m+n+1/2`个数,和第`m+n+2/2`个数字

### 继续

我们要在两个数组中查找第k个数字,从题目的时间复杂度看只能二分查找.

那么问题是对谁二分,对数组二分显然是不现实的,因为你有两个有序数组,这其实是一个没有完全排好序的集合,不满足基础二分的条件.

好在每一个数组有序性可以被我们利用,我们可以对k二分.

```java
 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        // 注意这里要除以2.0
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     *
     * @param nums1
     * @param i 数组nums1的开始位置
     * @param nums2
     * @param j 数组nums2的开始位置
     * @param k 查找第k个数字
     * @return
     */
    int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        // 数组nums1已经遍历完成 直接在nums2中查找.
        if(i>=nums1.length) return nums2[j+k-1];
        // 同上
        if(j>=nums2.length) return nums1[i+k-1];

        // 查找第1个元素,直接从两个数组头部返回
        if(k==1) return Math.min(nums1[i],nums2[j]);

        // 如果nums1中已经不存在第k/2个数字,
        // 比如nums1={0},
        //     nums2={0,1,2,3}
        //     查找第4个数字,k=4,k/2=2, i=0, j=0 ,i+k/2-1 = 1
        //     可以直接在nums2中排除0 1,因为无论nums1中的数字大还是小,都只有3个数字.
        //     所以nums2的起始j向后移动k/2,从index=2继续函数,第k-k/2=2个数字
        if (i+k/2-1 >= nums1.length){
            return findKth(nums1,i,nums2,j+k/2,k-k/2);
        }
        // 同上
        if (j+k/2-1 >= nums2.length){
            return findKth(nums1,i+k/2,nums2,j,k-k/2);
        }

        // 比如nums1={0,1},
        //     nums2={0,2,2,3}
        //     查找第4个数字,k=4,k/2=2, i=0, j=0 ,i+k/2-1 = 1
        //     由于nums1[1]<nums2[1],所以nums1的起始i向后移动k/2,从index=2继续函数,第k-k/2=2个数字
        if(nums1[i+k/2-1] < nums2[j+k/2-1]){
            return findKth(nums1,i+k/2,nums2,j,k-k/2);
        }else {
            return findKth(nums1,i,nums2,j+k/2,k-k/2);
        }

    }

```

