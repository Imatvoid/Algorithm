## 334. Increasing Triplet Subsequence

### Desc

Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

> Return true if there exists *i, j, k* 
> such that *arr[i]* < *arr[j]* < *arr[k]* given 0 ≤ *i* < *j* < *k* ≤ *n*-1 else return false.

**Note:** Your algorithm should run in O(*n*) time complexity and O(*1*) space complexity.

**Example 1:**

```
Input: [1,2,3,4,5]
Output: true
```

**Example 2:**

```
Input: [5,4,3,2,1]
Output: false
```



### 描述

在给定的数组中寻找依次上升的三个数字的子序列













### 思路

#### DP

```java
 /**
     * dp 方法 dp[i]代表 小于等于nums[i]的数量
     * @param nums
     * @return
     */
    public boolean increasingTripletDp(int[] nums) {
        // 边界处理
        if (nums.length < 3) return false;
        int n = nums.length;

        // dp[i]代表 小于等于nums[i]的数量
        int dp[] = new int[n];
        Arrays.fill(dp, 1);// 初始化为1 
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] >= 3) return true;
                }
            }
        }
        return false;
    }
```



### 易于理解的方法

数组forward，f[i]代表0-i中最小的数字

数组backward，b[i]代表i-n-1中最大的数字

nums:        8  3  5  1  6

foward:      8  3  3  1  1

backward:  8  6  6  6  6

我们发现数字5满足forward[i] < nums[i] < backward[i]，所以三元子序列存在。

```java
/**
     * 两个数组
     * @param nums
     * @return
     */
    public boolean increasingTripletEasyUnderstand(int[] nums) {
        if (nums.length < 3) return false;
        int n = nums.length;

        int f[] = new int[n];
        f[0] = nums[0];
        int b[] = new int[n];
        b[n - 1] = nums[n - 1];

        for (int i = 1; i < n; ++i) {
            f[i] = Math.min(f[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; --i) {
            b[i] = Math.max(b[i + 1], nums[i]);
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > f[i] && nums[i] < b[i]) return true;
        }
        return false;
    }
```



###  效率最高的方法 O(N)  O(1)



```java
  /** 效率最高的方法 O（N）  O（1）
     * @param nums 输入数组
     * @return
     */
    public boolean increasingTriplet(int[] nums) {

        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        for (int a : nums) {
            // 找到第一个数字
            if (a <= m1) m1 = a;
            // 找到第二个数 a>m1 
            else if (a <= m2) m2 = a;
            // 找到第三个数字 a>m1>m2
            else return true;
        }
        return false;
    }
```

