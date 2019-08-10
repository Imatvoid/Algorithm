## 136. Single Number

136. Single Number

<https://leetcode.com/problems/single-number/>

136. 只出现一次的数字

<https://leetcode-cn.com/problems/single-number/>


### 描述

一个数组,数字出现两次,只有一个数字出现一次。把它找出来。

给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:
```
输入: [2,2,1]
输出: 1
```
示例 2:
```
输入: [4,1,2,1,2]
输出: 4
```

### 思路

异或: 相同为0,不同为1。

一个数字与自己异或为0，再异或一次等于自己本身.

一个数字与0异或等于本身.

所以所有数字从头到位异或一遍，最后剩下的就是要找的数字。

举例：
```
110
110
-----
000


110
110
001
-----
001
```

```java
    /**
     * Single Number
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res =0;
        for(int i:nums){
            res ^=i;
        }
        return res;

    }
```


## 137. Single Number II

<https://leetcode.com/problems/single-number-ii/>

<https://leetcode-cn.com/problems/single-number-ii/>

### 描述

一个数组,数字出现3次,只有一个数字出现一次。把它找出来。

### 思路
这又是一种典型的思路

我们可以建立一个32位的数字，来统计每一位上1出现的个数，我们知道如果某一位上为1的话，   
那么如果该整数出现了三次，对3去余为0，我们把每个数的对应位都加起来对3取余，最终剩下来的那个数就是单独的数字。

```java
public int singleNumber(int[] nums) {
        
        int res = 0;
        for(int i=0;i<32;i++){
            int sum =0;
            for(int j=0;j<nums.length;j++){
                sum += (nums[j]>>i)&1;
            }
            if(sum%3!=0){
                res = res | (1<<i);
            }
        }
        return res;
        
    }
```

## 260. Single Number III

260. Single Number III

<https://leetcode.com/problems/single-number-iii//>

<https://leetcode.com/problems/single-number-iii//>

### 描述

一个数组,数字出现2次,只有2个数字出现一次。把这两个数字找出来。

### 思路

这是对上面第一道题的延伸。我们如何找出两个数字呢，如果只有一个数字，我们已经有方法找出。  
那么如何我们有办法将数组分成两组，一组有一个答案。那么问题就解决了。
所以问题是如何分组。

我们可以得到res1和res2的异或，
这意味着他们在这一位不同。
这便是分组的条件。


```java
 public int[] singleNumber(int[] nums) {
         int result[] = new int[2]; 
    // 得到res1异或res2
    int xor = nums[0];
    for (int i=1; i<nums.length; i++)
    {
        xor ^= nums[i];
    }
    
    //int bit = xor & ~(xor-1); 求出最右边的1
    int bit = (xor & -xor);
    int num1 = 0;
    int num2 = 0;
    
    for (int num : nums)
    {
        if ((num & bit) > 0)
        {
            num1 ^= num;
        }
        else
        {
            num2 ^= num;
        }
    }
    
    result[0] = num1;
    result[1] = num2;
    return result;
    }
```
















