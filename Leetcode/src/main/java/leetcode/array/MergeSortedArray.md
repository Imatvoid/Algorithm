88. Merge Sorted Array

<https://leetcode.com/problems/merge-sorted-array/>

88. 合并两个有序数组

<https://leetcode-cn.com/problems/merge-sorted-array/>

## 描述

给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

示例:

输入:
``````
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
``````

## 思路
归并排序的基本思路只不过要从后向前开始

```java
 public void merge(int A[], int m, int B[], int n) {
        int i = m-1,j=n-1;
        int k = m+n-1;
        // k 永远不会将i的值覆盖，在A[i]的值被使用之前。因为k = m + n-1 极限情况是一直k-- j--，那么k会=m;
        while (i>=0 && j>=0){
            A[k--]=A[i]>B[j] ?A[i--] :B[j--];
        }

        // B还有没用完的 A数组中的已经都往后移了
        while (j>=0){
            A[k--]=B[j--];
        }
    }
```