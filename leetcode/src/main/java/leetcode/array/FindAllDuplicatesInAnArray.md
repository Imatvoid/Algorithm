442. Find All Duplicates in an Array

<https://leetcode.com/problems/find-all-duplicates-in-an-array/>

442. 数组中重复的数据

<https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/>

## 描述

给定一个整数数组 a，其中`1 ≤ a[i] ≤ n` （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。

找到所有出现两次的元素。

你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

示例：
```
输入:
[4,3,2,7,8,2,3,1]

输出:
[2,3]
```


## 思路
将所有元素,移动到合适的位置。找到不符合的。
```java
 public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
                i--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                arr.add(nums[i]);
            }
        }
        return arr;

    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
```