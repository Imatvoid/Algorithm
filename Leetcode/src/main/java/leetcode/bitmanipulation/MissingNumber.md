`268. Missing Number`

<https://leetcode.com/problems/missing-number/submissions/>

`268. 缺失数字`

<https://leetcode-cn.com/problems/missing-number/submissions/>

## 描述

给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:
``````
输入: [3,0,1]
输出: 2
``````
示例 2:
```````
输入: [9,6,4,2,3,5,7,0,1]
输出: 8
```````
说明:
你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?

## 思路
让数组回到正确的位置找错误的.

```java
public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>=0 && nums[i]<=n-1 && nums[i] != nums[nums[i]]){
                swap(nums,i,nums[i]);
                i--;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0 || nums[i]>n-1 || nums[i] != nums[nums[i]]){
                return i;
            }
        }
        return n;
    }
    
    void swap(int nums[],int i,int j ){
         int t = nums[i];
         nums[i]=nums[j];
         nums[j]=t;
    }

```

位操作
```java
    /**
     * 缺的是0没关系，本来就是0
     * <p>
     * 从1-n 异或这个数组
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= (i + 1) ^ nums[i];
        }
        return res;

    }
```

