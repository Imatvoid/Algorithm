`41. First Missing Positive(首个缺失的正数)`

<https://leetcode.com/problems/first-missing-positive/submissions/>

`41. 缺失的第一个正数`

<https://leetcode-cn.com/problems/first-missing-positive/submissions/>

## 描述

给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

示例 1:
```
输入: [1,2,0]  
输出: 3  
```
示例 2:
```
输入: [3,4,-1,1]
输出: 2
```
示例 3:
```
输入: [7,8,9,11,12]
输出: 1
```
说明:

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。

## 思路

对于`[3,4,-1,1]` 来说,长度n=4,如果不缺失正数,则应为`[1,2,3,4]`.  
也就是数字 i 在数组 i-1 的位置上,这种情况,首个缺失的正数只能是n+1,也就是5.  

如果将`[3,4,-1,1]`中的正数移动到其应该在的位置上,数组调整为:  
value: `[1,-1,3,4]`.  
index: `[0, 1,2,3]`.  

这时候很容易发现缺失了2,因为在数组index=1的位置上,nums[index] != index+1  

按照这种思路,我们遍历数组将数组中的正数调整到合适的位置,注意这里的正数范围应该是1-n.  
然后遍历数组,找到第一个`nums[index != index+1`,返回`index+1`.  
如果没有找到,则返回n+1.  

```java
/**
     * 找到第一个丢失的正数
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                swap(nums, nums[i]-1, i);
                i--;
            }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return  n+1;

    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
```