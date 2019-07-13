## 238. Product of Array Except Self



### Desc

Given an leetcode.array `nums` of *n* integers where *n* > 1,  return an leetcode.array `output` such that `output[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

**Example:**

```
Input:  [1,2,3,4]
Output: [24,12,8,6]
```

**Note:** Please solve it **without division** and in O(*n*).

**Follow up:**
Could you solve it with constant space complexity? (The output leetcode.array **does not** count as extra space for the purpose of space complexity analysis.)



### 描述

这道题给定我们一个数组，让我们返回一个新数组，对于每一个位置上的数是其他位置上数的乘积，并且限定了时间复杂度O(n)，并且不让我们用除法。如果让用除法的话，那这道题就应该属于Easy，因为可以先遍历一遍数组求出所有数字之积，然后除以对应位置的上的数字。





### 思路

对于某一个数字，如果我们知道其前面所有数字的乘积，同时也知道后面所有的数乘积，那么二者相乘就是我们要的结果，所以我们只要分别创建出这两个数组即可，分别从数组的两个方向遍历就可以分别创建出乘积累积数组。







优化

```java
 public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int before[] = new int[n];

        Arrays.fill(before, 1);

        for (int i = 1; i < n ; i++) {
            before[i] = before[i-1] * nums[i-1];
        }
        
        int right = 1;
        for (int i = n-2; i >=0; i--) {
            right *= nums[i+1];
            before[i] = before[i] * right;
        }
        return before;

    }
```

