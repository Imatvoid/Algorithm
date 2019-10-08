`389. Find the Difference`

<https://leetcode.com/problems/find-the-difference/>

`389. 找不同`

<https://leetcode-cn.com/problems/find-the-difference/>

## 描述

给定两个字符串 s 和 t，它们只包含小写字母。

字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。


示例:
```
输入：
s = "abcd"
t = "abcde"

输出：
e

解释：
'e' 是那个被添加的字母。
```

## 思路
求一个数组中,只出现一次的数字.

```java

    /**
     * 本质和Single Number是一样的
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char[] comb = (s+t).toCharArray();
        int output = 0;
        for(char c:comb){
            output = output^c;
        }
        //return (char)output;
        return Character.toChars(output)[0];

    }
```