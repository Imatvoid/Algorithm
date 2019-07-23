原题链接:
<https://leetcode-cn.com/problems/add-binary/>
<https://leetcode.com/problems/add-binary/>
<!-- more -->
## 描述
给两个2进制字符串,求和.
示例 1:
```
输入: a = "11", b = "1"
输出: "100"
```
示例 2:
````
输入: a = "1010", b = "1011"
输出: "10101"
````
## 思路
求和有两步操作:
1.对应位相加,%进制,取得余数
2.如果有进位,/进制,拿到进位.
后面不过是迭代这两步操作.
一个小trick是,在最后,可能你还有一个进位,别忘了.比如示例2.

## 代码
给一种可以复用的模板方法.下面这种方法,只要把"2"换成"10",也是可以使用的.
```java
public class AddBinary {

    public String addBinary(String a, String b) {

        int i =a.length()-1,j =b.length()-1;
        StringBuffer sb =new StringBuffer();

        int carry = 0;
        while (i>=0 || j>=0){
            int n1 = i>=0? a.charAt(i--)-'0': 0;
            int n2 = j>=0? b.charAt(j--)-'0': 0;

            sb.append((n1 + n2 +carry)%2);
            carry = (n1 + n2 +carry)/2;

        }
        if(carry == 1){
            sb.append(1);
        }
        return  sb.reverse().toString();

    }
}
```







