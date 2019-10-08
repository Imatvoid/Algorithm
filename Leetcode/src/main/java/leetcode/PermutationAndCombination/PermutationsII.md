`47. Permutations II`

<https://leetcode.com/problems/permutations-ii/>

`47. 全排列 II`

<https://leetcode-cn.com/problems/permutations-ii/>

### 描述

给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:
```
输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

```

### 思路1

其实可以手动去重,那就和普通的全排列问题一样了。

但其实有更通用的做法,我们使用交换法。

我们每一次交换递归之前对元素进行检查，如果这个元素在前面还存在数值相同的元素，那么我们就可以跳过进行下一次循环递归

```java
 List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        fullArray(nums, 0, nums.length - 1);
        return  res;
    }


    private void fullArray(int[] array, int cursor, int end) {
        if (cursor == end) {
            //System.out.println(Arrays.toString(array));
            ArrayList<Integer> l = new ArrayList<Integer>();
            for (int i = 0; i < array.length; i++) {
                l.add(array[i]);
            }
            res.add(l);
        } else {
            for (int i = cursor; i <= end; i++) {
                if (!swapAccepted(array, cursor, i)) {
                    continue;
                }


                swap(array, cursor, i);
                fullArray(array, cursor + 1, end);
                // 恢复
                swap(array, cursor, i);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private  boolean swapAccepted(int[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            if (array[i] == array[end]) {
                return false;
            }
        }
        return true;
    }
```
