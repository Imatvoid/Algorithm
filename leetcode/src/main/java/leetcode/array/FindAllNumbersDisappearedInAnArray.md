448. Find All Numbers Disappeared in an Array

<https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/>

448. 找到所有数组中消失的数字

<https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/>

## 描述
给定一个范围在  `1 ≤ a[i] ≤ n` ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 `[1, n] `范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

示例:
``````
输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]
``````


## 思路

让所有的数字回到正确的位置.

```java
 public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
                i--;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
               list.add(i+1);
            }
        }
        return list;
    }

    void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
```