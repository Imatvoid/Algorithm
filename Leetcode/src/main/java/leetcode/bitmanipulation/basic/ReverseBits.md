`190. Reverse Bits`

<https://leetcode.com/problems/reverse-bits/>

`190. 颠倒二进制位`

<https://leetcode-cn.com/problems/reverse-bits/>

## 描述

颠倒给定的 32 位无符号整数的二进制位。

 
示例 1：
```
输入: 00000010100101000001111010011100
输出: 00111001011110000010100101000000
解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。

```

## 思路

```java
 public int reverseBits(int n) {

        int res =0;
        for(int i=31;i>=0;i--){
            int bit = (n>>i)&1;
            res |= bit<<(31-i);
        }
        return res;

    }
```