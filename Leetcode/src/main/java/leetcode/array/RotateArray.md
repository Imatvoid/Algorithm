## 189. Rotate Array

### Desc

Given an array, rotate the array to the right by *k* steps, where *k* is non-negative.

**Example 1:**

```
Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```

**Example 2:**

```
Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
```

**Note:**

- Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
- Could you do it in-place with O(1) extra space?



### 描述

将k-n-1个元素移动到数组前面



### 思路



#### 允许多余的空间
映射

i = > i+k %n

```java
/**
     * 多用空间
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

        k = k%nums.length;
        int len = nums.length;

        if (len > 1 && k > 0) {

            int[] arr = new int[len];
            for (int i =0; i< len; ++i)
              // 映射 i = > i+k %n
                arr[(i + k) % len] = nums[i];

            for (int i =0; i< len; ++i)
                nums[i] = arr[i];

        }
    }
```







#### in place 翻转数组

1 2 3 4 **5 6 7**   要移动到前面去
**4 3 2 1** 5 6 7   翻转前半部分
4 3 2 1 **7 6 5**   翻转后半部分
5 6 7 1 2 3 4   整个翻转





```java
 public void rotate(int[] nums, int k) {
        // 可能的测试用例 【1】 2  将最后两个元素移动到前面
        k %= nums.length;
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    /**
     * 翻转数组
     * @param nums
     * @param start
     * @param end
     */
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
```

