7. Reverse Integer

<https://leetcode.com/problems/reverse-integer/>

7. 整数反转

<https://leetcode-cn.com/problems/reverse-integer/>

## 描述
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:
```
输入: 123
输出: 321
```
 示例 2:
```
输入: -123
输出: -321
```
示例 3:
```
输入: 120
输出: 21
注意:
```
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。


## 思路

```java
public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (Math.abs(res) > Integer.MAX_VALUE / 10) return 0;
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
```
这里不用判断等于214748364(Integer.MAX_VALUE / 10)的情况.
即使等于的话,最后一位只会是1或者2（2实际也不可能,已超出）。不会超出int范围。

int 范围
 -2147483648～2147483647


```java
  public int reverse(int x) {
     
        long result = 0;
        while(x != 0) {
           
            result = result * 10 + x%10;
            x /= 10;
        }
        return(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE)?0:(int)result;
    }
```
