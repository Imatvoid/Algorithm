50. Pow(x, n)

<https://leetcode.com/problems/powx-n/>

50. Pow(x, n)

<https://leetcode-cn.com/problems/powx-n/>

## 描述
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:
```
输入: 2.00000, 10
输出: 1024.00000
```
示例 2:
```
输入: 2.10000, 3
输出: 9.26100
```
示例 3:
```
输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
```
说明:
```
-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
```

## 思路

注意边界情况,如果n是负数，要避免n=-2147483648溢出.

n = 13，13在二进制中表示为：00001101，那么13 = 2^3 + 2^2 + 2^0 = 8 + 4 +1.

m的13次方等于`m^2^3 * m^2^2  * m^2^1`,即`m^8 * m^4 * m^1`.与上面一一对应.

由此得出,我们只要在m的二进制=1的位置,累乘就可以。

```java
  public double myPow(double x, int n) {
        int m = n < 0 ? -(n + 1) : n;  //如果n是负数，要避免n=-2147483648溢出
        double p = 1;
        double q = x;
        while (m >= 1) {
            if ((m & 1) != 0) p *= q;  //一旦该位为1，那么将q乘入p中
            //System.out.println(q);
            q *= q;  //m每次除2，q就要变为平方
            m = m >> 1;
        }
        return n < 0 ? 1 / (p * x) : p;
    }
```
