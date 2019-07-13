## 300. Longest Increasing Subsequence



### Desc

Given an unsorted array of integers, find the length of longest increasing subsequence.

**Example:**

```
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
```

**Note:**

- There may be more than one LIS combination, it is only necessary for you to return the length.
- Your algorithm should run in O(*n2*) complexity.

**Follow up:** Could you improve it to O(*n* log *n*) time complexity?





### 描述

查找最长的上升子序列长度

### 思路

dp[i]是小于等于nums[i]的数个数

```java
 /**
     * 原生dp
     * @param nums
     * @return
     */
    public int lengthOfLISOriginalDP(int[] nums) {
        int n = nums.length;
      // 处理边界情况
        if(n==0){
            return 0;
        }

        int dp[] = new int[n];
      // 都初始化为1 
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > max) max = dp[i];
                }
            }
        }

        return max;
    }

```



Ologn dp + 二分

我们先建立一个数组ends，把首元素放进去，然后比较之后的元素，如果遍历到的新元素比ends数组中的当前元素大的话，就将此元素加进去，指针+1，否则（小于等于），给这个元素查找一个插入位置，替换原来的元素。以此类推直至遍历完整个nums数组，此时ends数组的长度就是我们要求的LIS的长度，特别注意的是ends数组的值可能不是一个真实的LIS，比如若输入数组nums为{4, 2， 4， 5， 3， 7}，那么算完后的ends数组为{2， 3， 5， 7}

```java
/**
 * 最长上升子序列 o nlogn
 * @param nums
 * @return
 */
public int lengthOfLIS(int[] nums) {
    // [10,9,2,5,3,7,101,18]
    if(nums == null || nums.length == 0) {
        return 0;
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int len = 0;
    for(int i = 1; i < nums.length; i++) {
        if(nums[i] > dp[len]) {
            dp[++len] = nums[i];
        }
        else {
            int index = binarySearch(dp, len, nums[i]);
            dp[index] = nums[i];
        }
    }
    return len + 1;
}

public static void main(String[] args) {
    new LongestIncreasingSubsequence().lengthOfLISOriginalDP(new int[]{0});
    new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
}

/**
 * 二分查找 查找插入位置 不小于
 * @param leetcode.dp
 * @param len
 * @param val
 * @return
 */
private int binarySearch(int[] dp, int len, int val) {
    int start = 0;
    while(start <= len) {
        int mid = start + (len - start) / 2;

        if(dp[mid] < val) {
            start = mid + 1;
        }
        else {
            len = mid - 1;
        }
    }
    return start;
}
```

​                                                                                                                                                                                                                                                                                                          