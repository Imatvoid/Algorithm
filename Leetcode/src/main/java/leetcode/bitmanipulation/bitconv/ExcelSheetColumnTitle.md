`168. Excel Sheet Column Title`

<https://leetcode-cn.com/problems/excel-sheet-column-title/>

`168. Excel表列名称`

<https://leetcode-cn.com/problems/excel-sheet-column-title/>

## 描述

给定一个正整数，返回它在 Excel 表中相对应的列名称。

例如，
```
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
```
示例 1:
```
输入: 1
输出: "A"
```
示例 2:
```
输入: 28
输出: "AB"
```

## 思路

```java
 /**
     * 实质是26进制转换,但26=Z 需特殊处理
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int a = n % 26;
            if(a == 0) {
                sb.append('Z');
                n = n / 26 - 1;
            }
            else {
                // 这里要小心,不转换成char类型的话会变成数字
                sb.append((char)(n % 26 -1 + 'A'));
                n = n / 26;
            }
        }
        return sb.reverse().toString();
    }
```