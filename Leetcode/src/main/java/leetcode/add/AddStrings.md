原题链接
<https://leetcode-cn.com/problems/add-strings/>
<https://leetcode.com/problems/add-strings/>
<!-- more -->

## 描述
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

注意：
num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。


## 思路
求和有两步操作:
1.对应位相加,%进制,取得余数
2.如果有进位,/进制,拿到进位.
后面不过是迭代这两步操作.
一个小trick是,在最后,可能你还有一个进位,别忘了.

## 代码
```java
public class AddStrings {

    public String addStrings(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();

        int i = len1 - 1, j = len2 - 1;

        int over = 0;


        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j--) - '0' : 0;

            sb.append((a + b + over) % 10);
            over = (a + b + over) / 10;
        }

        if (over > 0) {
            // 9 + 9  = 18 
            sb.append(1);
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("584", "18"));
    }
}
```

## 其他
这一类的题目可以在leetcode-add 标签下找到