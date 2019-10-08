`169. Majority Element`

<https://leetcode.com/problems/majority-element/>

`169. 求众数`

<https://leetcode-cn.com/problems/majority-element/>

## 描述

给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:
```
输入: [3,2,3]
输出: 3
```
示例 2:
```
输入: [2,2,1,1,1,2,2]
输出: 2
```

## 思路
统计数字每一个二进制位,如果这个二进制位上1出现的次数大于数组长度的一半,就保留下来.

```java

    /**
     * 一个数字和其他数字出现的次数不一样，都可以这样做。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        int res =0;
        for(int i=0;i<32;i++){
            int sum =0;
            for(int n:nums){
                sum+= (n>>i)&1;
            }
            if(sum>(nums.length/2)){
                res |= 1<<i;
            }
        }
        return res;

    }

```
