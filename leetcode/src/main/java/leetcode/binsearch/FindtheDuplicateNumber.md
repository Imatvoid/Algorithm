287. Find the Duplicate Number

<https://leetcode.com/problems/find-the-duplicate-number/>

287. 寻找重复数

<https://leetcode-cn.com/problems/find-the-duplicate-number/>


## 描述
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

示例 1:
```
输入: [1,3,4,2,2]
输出: 2
```
示例 2:
```
输入: [3,1,3,4,2]
输出: 3
```
说明：

不能更改原数组（假设数组是只读的）。   
只能使用额外的 O(1) 的空间。   
时间复杂度小于 O(n2) 。  
数组中只有一个重复的数字，但它可能不止重复出现一次。   

## 思路

假设n=5, array={1,2,3,4,5}.  允许其中任何一个数字重复,假设2重复      

array={1,2,2,3,4,5},现在数组的数量是n+1了.

这是重复一次情况,其实可以重复多次.

array={1,2,2,2,4,5} 现在长度还是n+1.

我们知道我们要求的数字肯定在1-n之间. 观察一下上面

2的重复造成了什么呢,原来数组中小于等于3的数字应该是3个(1，2,3).

现在明显大于3了.所以我们要求的数字肯定在1-3之间(可能是3重复)

所以这个题可以用二分法来解.


```java
public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left =1,right=n;
        // 结束left=right
        while(left<right){
            int mid = left + (right-left)/2;
            int count =0;
            for(int i:nums){
                if(i<=mid)
                    count ++;
            }
            System.out.println(mid);
            if(count>mid){
                right = mid;

            }
            else{
                left = mid +1;
            }
        }
        return left;
    }
```
