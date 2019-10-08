`393. UTF-8 Validation`

<https://leetcode.com/problems/utf-8-validation/>

`393. UTF-8 编码验证`

<https://leetcode-cn.com/problems/utf-8-validation/>


## 描述

UTF-8 中的一个字符可能的长度为 **1 到 4 字节**，遵循以下的规则：

1. 对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
2. 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。

这是 UTF-8 编码的工作方式：

```
   Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
```

给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。

**注意:**
输入是整数数组。只有每个整数的**最低 8 个有效位**用来存储数据。这意味着每个整数只表示 1 字节的数据。

**示例 1:**

```
data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.

返回 true 。
这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
```

**示例 2:**

```
data = [235, 140, 4], 表示 8 位的序列: 11101011 10001100 00000100.

返回 false 。
前 3 位都是 1 ，第 4 位为 0 表示它是一个3字节字符。
下一个字节是开头为 10 的延续字节，这是正确的。
但第二个延续字节不以 10 开头，所以是不符合规则的。
```





## 思路

从头开始校验即可,如果当前字节的情况是110/1110/11110,则校验后续1/2/3个字节是否是10xxxxxx

```java
 public boolean validUtf8(int[] data) {

        int cnt = 0;
        for(int d : data){
            if(cnt == 0){
                if((d>>5) == 0b110) cnt = 1; // 2 byte, followed by 1 more byte
                else if((d>>4) == 0b1110) cnt=2; // 3byte, followed by 2 more bytes
                else if((d>>3) == 0b11110) cnt=3; // 4 byte, followed by 3 more bytes
                else if((d>>7) != 0) return false;// 1 byte ASCII code, check it not big than 128
            }else{
                if((d>>6) != 0b10) return false;
                cnt--;
            }
        }
        return cnt == 0;
    }
```

